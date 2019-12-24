package Informal.mybatis.Controller.Websocket;



import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes){
        if(((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false).getAttribute("username")==null){
            System.out.println("Before Handshake");
            System.out.println("未知用户"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession().getId()+"connected");
        }
        else{
            System.out.println("Before Handshake");
            System.out.println("用户"+((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession().getAttribute("username")+"connected");
        }
        /*if (serverHttpRequest instanceof ServletServerHttpRequest) {*/
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session=servletRequest.getServletRequest().getSession(false);
            String username=(String) session.getAttribute("username");
            if (username != null) {
                attributes.put("username", username);  //将用户标识放入参数列表后，下一步的websocket处理器可以读取这里面的数据
            }
            else{
                attributes.put("username","未知用户sessionid为：    "+session.getId());
            }

        return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler,Exception e) {
        System.out.println("After Handshake");
        System.out.println("连接者ID是："+((ServletServerHttpRequest)serverHttpRequest).getServletRequest().getSession(false).getId());
        System.out.println("连接者名字是："+((ServletServerHttpRequest)serverHttpRequest).getServletRequest().getSession(false).getAttribute("username"));
/*
* 注意:1serverHttpRequest得到的是系统的session，跟shiro的session完全相同
*2.attributes是websocket的，put将相关的信息保存到了session.getAttributes()，得到了相关的数据
*
*
*
* */

    }
}
