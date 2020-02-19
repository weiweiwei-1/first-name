package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/Friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @RequestMapping(value="friendList",method={RequestMethod.GET,RequestMethod.POST})
    public String friendList(Model model) {
        int userId = UserUtils.getUserVo().getId();
        List<Friend> friendLists = friendService.showFriendList(userId);
        model.addAttribute("friends",friendLists);
        return "mainproject/friendList";
    }
}
