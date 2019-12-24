package Informal.mybatis.Controller.Websocket;


import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
@RequestMapping(value = "/websocket")
public class MyWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private UserService userService;
    private static final Map<String,WebSocketSession> map = new HashMap<>();
    @Override
    @OnMessage
    @RequestMapping(value = "/websocket1")
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage){
        String username=(String)webSocketSession.getAttributes().get("username");
        JSONObject jo=JSONObject.parseObject(textMessage.getPayload());
        System.out.println("接收者为"+jo.get("receiver"));
        System.out.println("消息内容为"+jo.get("message"));
        String receiver=(String)jo.get("receiver");
        String message=(String)jo.get("message");
        // 获取提交过来的消息详情
        System.out.println("用户 " + username + "   发出消息:" + message);
        User user=userService.selectByName(receiver);
        if(receiver.equals("所有人")){
            sendMessageToUsers(username+":"+message,webSocketSession);
        }
        else if(user==null){
            sendMessageToUser(username,"不存在用户:     "+receiver);
        }
        else if(map.get(receiver)!=null){
            if(map.get(receiver).isOpen())
                sendMessageToUser(receiver,username+":"+message);
                System.out.println(receiver+"收到消息");
            }
            else{
            sendMessageToUser(username,"用户不在线");
        }

    }
           /* if (messageInfo.length!=2) {
                sendMessageToUser(username, new TextMessage("500@服务器出错请稍后再发送吧"));
            } else {
                String target = messageInfo[0];
            String content = messageInfo[1];
            // 遍历所有已连接用户
            for (String un:map.keySet()) {
                System.out.println(map.get(un).getAttributes().get("username"));
                if (map.get(un).getAttributes().get("username").equals(target)) {
                    //遇到匹配用户 连接正常则发送消息
                    if (map.get(un).isOpen()) {
                        sendMessageToUser(target, new TextMessage("200@"+content));
                    }else{//若异常则发送失败
                        sendMessageToUser(username, new TextMessage("404@对方在线异常,发送失败"));
                    }
                    return;
                }
            }
            //未找到匹配用户 发送失败
            sendMessageToUser(username, new TextMessage("404@对方暂时不在线"));
        }
        System.out.println("执行完");*/
    @Override
     @OnOpen
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        map.put((String)session.getAttributes().get("username"),session);
        String username = (String) session.getAttributes().get("username");
        System.out.println("OnOpen后：");
        System.out.println("用户 " + username + " Connection Established");
        session.sendMessage(new TextMessage(username + " connect"));

    }
    @Override
    @OnClose
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        String username = (String) session.getAttributes().get("username");
        System.out.println("OnClosed后:");
        System.out.println("用户 " + username + " Connection closed. Status: " + status);
        map.remove(username);
    }

    @Override
    @OnError
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("OnError后：");
        System.out.println("用户: " + username + " websocket connection closed......");
        map.remove(username);
    }
    private void sendMessageToUsers(String message,WebSocketSession webSocketSession) {

        for (String id : map.keySet()) {
            try {
                if (map.get(id).isOpen()&&!map.get(id).equals(webSocketSession)) {
                    map.get(id).sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessageToUser(String username, String message) {
        if(map.get(username)!=null){
            if(map.get(username).isOpen()){
                try {
                    map.get(username).sendMessage(new TextMessage(message));
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
       /* for (String  id : map.keySet()) {
            if (map.get(id).getAttributes().get("username").equals(username)) {
                try {
                    if (map.get(id).isOpen()) {
                        map.get(id).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }*/



