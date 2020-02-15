package Informal.mybatis.Controller.Websocket;


import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.Base.WebSocketUtils;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.websocket.;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private UserService userService;
    private static final Map<String,WebSocketSession> map = new HashMap<>();
    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage){
        String username=(String)webSocketSession.getAttributes().get("username");
        JSONObject jo=JSONObject.parseObject(textMessage.getPayload());
        System.out.println("接收者为"+jo.get("receiver"));
        System.out.println("消息内容为"+jo.get("message"));
        String receiver=(String)jo.get("receiver");
        String message=(String)jo.get("message");
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
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        map.put((String)session.getAttributes().get("username"),session);
        String username = (String) session.getAttributes().get("username");
        System.out.println("OnOpen后：");
        System.out.println("用户 " + username + " Connection Established");
        session.sendMessage(new TextMessage(username + " connect"));
        }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        String username = (String) session.getAttributes().get("username");
        System.out.println("OnClosed后:");
        System.out.println("用户 " + username + " Connection closed. Status: " + status);
        map.remove(username);
    }

    @Override
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


