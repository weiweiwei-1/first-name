package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.Base.WebSocketUtils;
import Informal.mybatis.Controller.ExtrateOperate.CompareSimilarity;
import Informal.mybatis.Model.AddUser;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.AddUserService;
import Informal.mybatis.Service.FriendService;
import Informal.mybatis.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/AddUser")
public class AddUserController {
    @Autowired
    private AddUserService addUserService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private UserService userService;
    @Autowired
    private Gson gson;
    @RequestMapping(value="/SystemRecommend")
    public String SystemRecommend(Model model) {
        User user = UserUtils.getUserVo();
        String userSchool = user.getSchool();
        String userCompany = user.getCompany();
        List<User> userList = userService.selectAll();
        List<User> systemList = new ArrayList<>();
        Integer count = 0;
        Integer key;
        Map<Integer,User> map = new HashMap<>();
        int i;
        for(i = 0; i < userList.size(); i++) {
            map.put(userList.get(i).getId(),userList.get(i));
        }
        map.remove(user.getId());
        List<Friend> friendLists = friendService.showFriendList(user.getId());
        for(i = 0; i < friendLists.size(); i++) {
            map.remove(friendLists.get(i).getFriendId());
        }
        for(Map.Entry<Integer, User> entry: map.entrySet()) {
            key = entry.getKey();
            if(CompareSimilarity.compare(userSchool, map.get(key).getSchool()) >= 66 || CompareSimilarity.compare(userCompany, map.get(key).getCompany()) >= 66) {
                systemList.add(map.get(key));
                count ++;
            }
            if(count > 300) {
                break;
            }
        }
        model.addAttribute("userList", systemList);
        return "mainproject/systemUserList";
    }

    @RequestMapping(value="/showUser",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public User showUser(Integer userId) {
        if (userId == null) {
            return null;
        }
        return userService.selectByPrimaryKey(userId);
    }

    @RequestMapping(value="/sendAddUser",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Integer sendAddUser(AddUser addUser) {
        Integer addId = UserUtils.getUserId();
        Integer beAddId = addUser.getBeAddId();
        User user = userService.selectByPrimaryKey(addId);
        addUser.setUserPhoto(user.getPhoto());
        addUser.setUserName(user.getUsername());
        addUser.setAddId(addId);
        int count = addUserService.sendAddUserApplication(beAddId, addId, addUser.getAddName());
        addUser.setMessageType("addUser");
        if (count!=0) {
            if (WebSocketUtils.hasConnection(String.valueOf(beAddId))) {
                WebSocketUtils.get(String.valueOf(beAddId)).getAsyncRemote().sendText(gson.toJson(addUser));
            }

        }
        return count;
    }

    @RequestMapping(value="/showAddUser",method={RequestMethod.GET,RequestMethod.POST})
    public String showAddUser(Model model) {
        Integer userId = UserUtils.getUserId();
        List<AddUser> addUserList = addUserService.showAddUserList(userId);
        List<Integer> userList = new ArrayList<>();
        if(addUserList.size() > 0) {
            for (int i = 0; i < addUserList.size(); i ++) {
                userList.add(addUserList.get(i).getAddId());
            }
        }
        if (userList.size() > 0) {
        List<User> userLists = userService.selectAllList(userList);
        for(int j = 0; j < addUserList.size(); j++) {
            addUserList.get(j).setUserName(userLists.get(j).getUsername());
            addUserList.get(j).setUserPhoto(userLists.get(j).getPhoto());
            }
        }
        model.addAttribute("addUserList",addUserList);
        return "mainproject/userApplicationList";
    }
}
