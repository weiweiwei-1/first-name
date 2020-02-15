package Informal.mybatis.Controller.Websocket;



import Informal.mybatis.Controller.Base.WebSocketUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor{
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes){
        if(((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false).getAttribute("id")==null){
            System.out.println("Before Handshake");
            System.out.println("未知用户"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession().getId()+"connected");
        }
        else{
            System.out.println("Before Handshake");
            System.out.println("用户"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession().getAttribute("id")+"connected");
        }
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session=servletRequest.getServletRequest().getSession(false);
            Integer id =(Integer) session.getAttribute("id");
            if (id != null) {
                attributes.put("id", id);  //将用户标识放入参数列表后，下一步的websocket处理器可以读取这里面的数据
            } else {
                return false;
            }
            return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler,Exception e) {
        System.out.println("After Handshake");
        System.out.println("连接者ID是："+((ServletServerHttpRequest)serverHttpRequest).getServletRequest().getSession(false).getAttribute("id"));
        }
}
