package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.MessageMapper;
import Informal.mybatis.Model.DataStructure.DataStructure;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.enty.UnReadMessageList;
import Informal.mybatis.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private DataStructure dataStructure;
    @Override
    public int sendMessage(int userId, int friendId,String content) {
        Message message=new Message(userId,friendId,content);
        Friend friendBase=new Friend(userId,friendId);
        Friend friend=friendMapper.selectFriendUnion(friendBase);
        if(friend!=null){
            messageMapper.insertMessage(message);
            return message.getId();
        }
        return 0;
    }

    public List<Message> selectAllMessages(int userId,int friendId){
        Message message=new Message(userId,friendId);
        return messageMapper.selectMessages(message);
    }

    @Override
    public List<UnReadMessageList> unReadMessageList(int userId) {
        List<UnReadMessageList> messageList=messageMapper.selectUnReadMessageList(userId);
        List<Friend> friendList=friendMapper.selectFriendListById(userId);
        System.out.println(dataStructure.createRandomInteger(messageList,friendList));
        return dataStructure.createRandomInteger(messageList,friendList);
    }

    @Override
    public int deleteMessages(int userId, int friendId) {
        Message message=new Message(userId,friendId);
        return messageMapper.deleteMessages(message);
    }

    @Override
    public int deleteMessageById(int id,int userId) {
        return messageMapper.deleteMessageByIdAndSenderId(id,userId);
    }

    @Override
    public int deleteAllMessages(int userId, int friendId) {
        Message message=new Message(userId,friendId);
        return messageMapper.deleteAllMessages(message);
    }
}
