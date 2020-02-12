package Informal.mybatis.test4.formalProjectTest;


import Informal.mybatis.Model.AddUser;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Service.AddUserService;
import Informal.mybatis.Service.FriendService;
import Informal.mybatis.Service.MessageService;
import Informal.mybatis.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {
    private FriendService friendService;
    private AddUserService addUserService;
    private MessageService messageService;
    private UserService userService;
    @Before
    public void setUp(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        friendService=(FriendService)ac.getBean("friendServiceImpl");
        addUserService=(AddUserService)ac.getBean("addUserServiceImpl");
        messageService=(MessageService)ac.getBean("messageServiceImpl");
        userService = (UserService)ac.getBean("userServiceImpl");
    }

    @Test
    public void sendAddUserApplication(){
        System.out.println(addUserService.sendAddUserApplication(10,15,"威震天"));
    }

    @Test
    public void permitAddUser(){
        System.out.println(addUserService.permitAddUser(10,15,"威擎天柱"));
    }

    @Test
    public void permitAddUserById(){
        System.out.println(addUserService.permitAddUserById(9,15,"威震天"));
    }

    @Test
    public void rejectAddUser(){
        addUserService.rejectAddUser(1,20);
    }

    @Test
    public void rejectAddUserById(){
        System.out.println(addUserService.rejectAddUserById(6,1));
    }

    @Test
    public void showAddUserList(){
        List<AddUser> lists=addUserService.showAddUserList(1);
        System.out.println(lists);
    }

    @Test
    public void showFriendList(){
        List<Friend> list=friendService.showFriendList(20);
        System.out.println(list);
    }

    @Test
    public void deleteFriend(){
        friendService.deleteFriend(21,15);
    }

    @Test
    public void deleteFriendById(){
         System.out.println(friendService.deleteFriendById(7,10));
    }

    @Test
    public void updateFriendMark(){
         friendService.updateFriendMark(21,10,"bbb");
    }

    @Test
    public void updateFriendMarkById(){
        friendService.updateFriendMarkById(2,6,"丹丹");
    }

    @Test
    public void sendMessage(){
        int a=messageService.sendMessage(10,15,"disige");
        System.out.println(a);
    }

    @Test
    public void selectAllMessages(){
        List<Message> lists=messageService.selectAllMessages(10,1);
        System.out.println(lists);
    }

    @Test
    public void selectUnReadMessageList(){
        System.out.println(messageService.unReadMessageList(15));
    }

    @Test
    public void deleteMessage(){
        messageService.deleteMessages(1,10);
    }


    @Test
    public void deleteMessageById(){
        messageService.deleteMessageById(15,10);
    }

    @Test
    public void deleteAllMessages(){
        messageService.deleteAllMessages(15,10);
    }

    @Test
    public void selectByEmail() {
        userService.selectByEmail("123`123");
    }

}
