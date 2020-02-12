package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Model.User;
import Informal.mybatis.Model.enty.ReadAndUnReadMessageList;
import Informal.mybatis.Service.FriendService;
import Informal.mybatis.Service.MessageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/ChatPage")
public class ChatPageController {

    @Autowired
    MessageService messageService;

    @Autowired
    FriendService friendService;

    @RequestMapping(value="/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(Model model, HttpServletRequest request,HttpSession session) {
        User user = UserUtils.getUserVo();
        System.out.println(user);
        try{
            /*Session session = SecurityUtils.getSubject().getSession(false);
            int userId =  (Integer)session.getAttribute("id");*/
            session = request.getSession(false);
            int userId = (Integer)session.getAttribute("id");
            System.out.println("session的ID为："+ userId);
            List<ReadAndUnReadMessageList> readAndUnReadMessageLists = messageService.readAndUnReadMessageList(userId);
            System.out.println(readAndUnReadMessageLists);
            model.addAttribute("allMessageList",readAndUnReadMessageLists);
            model.addAttribute("user",user);
            return "mainproject/chat";
        } catch (NullPointerException e) {
            return "redirect:/";
        }
    }

}
