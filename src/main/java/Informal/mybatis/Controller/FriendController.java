package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.FriendService;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/Friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/friendList",method={RequestMethod.GET,RequestMethod.POST})
    public String friendList(Model model) {
        int userId = UserUtils.getUserVo().getId();
        List<Friend> friendLists = friendService.showFriendList(userId);
        model.addAttribute("friends",friendLists);
        return "mainproject/friendList";
    }

    @RequestMapping(value="/showFriendInformation",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public User showFriendInformation(Integer friendId) {
        User user = userService.selectByPrimaryKey(friendId);
        Integer userId = UserUtils.getUserId();
        Friend friendBase = new Friend(userId, friendId);
        Friend friend = friendService.selectFriendMark(friendBase);
        user.setUserMark(friend.getFriendMark());
        return user;
    }

    @RequestMapping(value="/updateFriendMark",method={RequestMethod.GET,RequestMethod.POST})
    public void updateFriendMark(){

    }
}
