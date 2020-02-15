package Informal.mybatis.Controller;


import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.Base.WebSocketUtils;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.MessageService;
import Informal.mybatis.Service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/Message")
public class MessageController {
    @Autowired
    private Gson gson;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/messageContent",method={RequestMethod.GET,RequestMethod.POST})
    public String chatContent(Model model, int friendId) {
        Integer userId = UserUtils.getUserVo().getId();
        String photo = UserUtils.getUserVo().getPhoto();
        List<Message> messages = messageService.selectAllMessages(userId, friendId);
        System.out.println(messages);
        User friend = userService.selectByPrimaryKey(friendId);
        model.addAttribute("messages", messages);
        model.addAttribute("userId", userId);
        model.addAttribute("friendId", friendId);
        model.addAttribute("userPhoto", photo);
        model.addAttribute("friendPhoto", friend.getPhoto());
        return "mainproject/message";
    }

    @RequestMapping(value="/readMessages",method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void readMessage(String friendId) {
        Integer userId = UserUtils.getUserVo().getId();
        Integer newFriendId = Integer.valueOf(friendId);
        //收到消息将消息状态转换为1，表示消息已读出，检查对方是否在线，如果在线，将已读的消息发送给对方，前端判断消息类型，然后做出相应的处理
        messageService.readMessages(userId, newFriendId);
        Message message = new Message(newFriendId, userId);
        message.setMessageType("hasRead");
        if (WebSocketUtils.hasConnection(friendId)) {
            Gson gson1 =  new Gson();
            WebSocketUtils.get(friendId).getAsyncRemote().sendText(gson1.toJson(message));
        }
    }

    @RequestMapping(value="/sendMessage",method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer sendMessage(Message message) throws Exception{
        Integer userId = UserUtils.getUserVo().getId();
        int friendId = message.getReceiverId();
        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date trueSendTime = format.parse(message.getSendTime());
        System.out.println(trueSendTime);*/
        message.setSenderId(userId);
        message.setMessageType("sendMessage");
        int messageId = messageService.sendAllMessage(message);
        if (WebSocketUtils.hasConnection(String.valueOf(message.getReceiverId()))) {
            WebSocketUtils.get(String.valueOf(friendId)).getAsyncRemote().sendText(gson.toJson(message));
        }
        return messageId;
    }
}
