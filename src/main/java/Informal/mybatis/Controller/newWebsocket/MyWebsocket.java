package Informal.mybatis.Controller.newWebsocket;

import Informal.Spring.Annotation.Model.total_Annotation.SpringconfigurationB;
import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.Base.WebSocketUtils;
import Informal.mybatis.Model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

@Component
@ServerEndpoint(value="/websocket/socketServer",configurator = WebSocketConfig.class)
public class MyWebsocket {
    @OnOpen
    public void onOpen(Session session) {
       User user = (User)session.getUserProperties().get("user");
       if(user.getId() != null) {
           WebSocketUtils.put(String.valueOf(user.getId()), session);
       }
       System.out.println("目前的用户有：");
       for (String key: WebSocketUtils.getWebsocketSession().keySet()){
           System.out.println(WebSocketUtils.get(key));
       }
//       将上线的消息发送给所有的在线好友
    }

    @OnMessage
    public void noMessage(Session session, String message) {

    }

    @OnClose
    public void onClose(Session session) throws Exception {
        User user = (User)session.getUserProperties().get("user");
        if(user.getId() != null) {
            WebSocketUtils.removeSession(String.valueOf(user.getId()));
//            将下线的消息发送给所有的在线好友
        }
    }

    @OnError
    public void OnError(Session session, Throwable error) throws Exception{
        String userId = (String)session.getUserProperties().get("id");
        if(WebSocketUtils.getWebsocketSession().containsKey(String.valueOf(userId))) {
            WebSocketUtils.removeSession(userId);
//            将下线的消息发送给所有的在线好友
        };
        error.printStackTrace();
        System.out.println("cuowu");
    }
}
