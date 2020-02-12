package Informal.mybatis.test4.formalProjectTest;

import Informal.mybatis.Dao.AddUserMapper;
import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.MessageMapper;
import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.AddUser;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.enty.FriendChatList;
import Informal.mybatis.Model.enty.UnReadMessageList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

public class MapperTest {
    private FriendMapper friendMapper;
    private AddUserMapper addUserMapper;
    private MessageMapper messageMapper;
    private UserMapper userMapper;

    @Before
    public void setUp() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        friendMapper = (FriendMapper) ac.getBean("friendMapper");
        addUserMapper = (AddUserMapper) ac.getBean("addUserMapper");
        messageMapper = (MessageMapper) ac.getBean("messageMapper");
        userMapper = (UserMapper) ac.getBean("userMapper");
    }

    @Test
    public void testFriendInsert() {
        Friend friend = new Friend(20, 18, "laa", "hedf ei");
        friendMapper.insertFriend(friend);
    }

    @Test
    public void judgeUserIdPosition() {
        Friend friend = new Friend(1,5);
        Friend friend1=friendMapper.judgeUserIdPosition(friend);
        if(friend1==null){
            System.out.println("userId不在左边");
        }else{
            System.out.println("userId在左边");
        }
    }

    @Test
    public void selectFriendById(){
        Friend friend =friendMapper.selectFriendById(4);
        System.out.println(friend);
    }

    @Test
    public void judgeFriend() {
        Friend friend = new Friend(1,10);
        Friend friend1=friendMapper.judgeFriend(friend);
        if(friend1==null){
            System.out.println("朋友关系不存在");
        }else{
            System.out.println("朋友关系存在");
        }
    }

    @Test
    public void testFriendSelect() {
        Friend friend = new Friend();
        friend.setUserId(10);
        List<Friend> friend1 = friendMapper.selectFriendList(friend);
        System.out.println(friend1);
    }

    @Test
    public void testFriendMarkUpdate() {
        Friend friend = new Friend(1, 10, "丹丹");
        friendMapper.updateFriendMark(friend);
    }

    @Test
    public void testUserMarkUpdate() {
        Friend friend = new Friend(10, 1, "威古");
        friendMapper.updateUserMark(friend);
    }

    @Test
    public void deleteFriend() {
        Friend friend = new Friend(1,10);
        friendMapper.deleteFriend(friend);
    }

    @Test
    public void friendChatList() {
        List<FriendChatList> list=messageMapper.frendChatList(10);
        System.out.println(list);
    }


    @Test
    public void insertAddUser() {
        AddUser addUser=new AddUser(1,10,"曾庆威");
        addUserMapper.insertAddUser(addUser);
    }

    @Test
    public void deleteAddUser(){
        AddUser addUser=new AddUser(1,10);
        addUserMapper.deleteAddUser(addUser);
    }

    @Test
    public void selectChatFrinedList(){
        Message message=new Message();
        message.setReceiverId(10);
        List<FriendChatList> list=messageMapper.frendChatList(10);
        System.out.println(list);
    }

    @Test
    public void selectlastUnkonwread(){
        Message message=new Message(1,10);
        Message message1=messageMapper.selectLastUnReadMessage(message);
        System.out.println(message1);
    }

    @Test
    public void selectMessages(){
        Message message=new Message(10,1);
        List<Message> list=messageMapper.selectMessages(message);
        System.out.println(list);
    }
    @Test
    public void deleteMessage(){
        messageMapper.deleteMessageById(5);
    }

    @Test
    public void selectLastUnReadMessage(){
        Message message=new Message(1,10);
        Message message1=messageMapper.selectLastUnReadMessage(message);
        System.out.println(message1);
    }

    @Test
    public void selectLastUnReadMessage2(){
        List<UnReadMessageList> lists=messageMapper.selectUnReadMessageList(15);
        System.out.println(lists);
    }

    @Test
    public void deleteAllMessage(){
        Message message=new Message(15,10);
        messageMapper.deleteAllMessages(message);
    }

    @Test
    public void withdrawUserMessages(){
        Message message=new Message(10,1);
        messageMapper.withDrawUserMessages(message);
    }

    @Test
    public void insertMessage(){
        Message message=new Message(20,18,"嘻嘻哈");
        messageMapper.insertMessage(message);
    }

    @Test
    public void selectByEamil() {
        userMapper.selectByEmail("123`2123`");
    }

}
