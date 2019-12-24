package Informal.mybatis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/WebSocket")
public class WebSocketController {
    @RequestMapping("/Websocket1")
    public String websocket(){
        return "Websocket/ChatPage";
    }
}
