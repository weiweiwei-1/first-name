package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.MessageMapper;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.User;
import Informal.mybatis.Model.enty.ReadAndUnReadMessageList;
import Informal.mybatis.Model.enty.UnReadMessageList;
import Informal.mybatis.Service.MessageService;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    UserService userService;

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
    public int sendAllMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public int readMessages(int userId, int friendId) {
        Message message = new Message(friendId, userId);
        return messageMapper.updateMessages(message);
    }


    @Override
    public List<ReadAndUnReadMessageList> readAndUnReadMessageList(int userId) {
        List<UnReadMessageList> unReadMessageLists = messageMapper.selectUnReadMessageList(userId);
        List<ReadAndUnReadMessageList> readAndUnReadMessageLists = messageMapper.selectReadAndUnReadMessageList(userId);
        List<Friend> friendLists = friendMapper.selectFriendListById(userId);
        int url = unReadMessageLists.size();
        int raul = readAndUnReadMessageLists.size();
        int fl = friendLists.size();
        if (raul == 0 || fl == 0) {
            return null;
        }
        int i = 0, j = 0;
        while (i < url && j < raul) {
            if (unReadMessageLists.get(i).getFriendId() < readAndUnReadMessageLists.get(j).getFriendId()) {
                i++;
                readAndUnReadMessageLists.get(j).setUnReadMessageCount(0);
            } else if (unReadMessageLists.get(i).getFriendId()>readAndUnReadMessageLists.get(j).getFriendId()) {
                j++;
                readAndUnReadMessageLists.get(j).setUnReadMessageCount(0);
            } else {
                readAndUnReadMessageLists.get(j).setUnReadMessageCount(unReadMessageLists.get(i).getUnReadMessageCount());
                i++;
                j++;
            }
        }
        i = 0; j = 0;
        while (i < raul && j < fl) {
            if (readAndUnReadMessageLists.get(i).getFriendId() < friendLists.get(j).getFriendId()) {
                i++;
            } else if (readAndUnReadMessageLists.get(i).getFriendId() > friendLists.get(j).getFriendId()) {
                j++;
            } else {
                readAndUnReadMessageLists.get(i).setFriendMark(friendLists.get(j).getFriendMark());
                i++;
                j++;
            }
        }
        List<Integer> friendIdLists =  new ArrayList<>();
        for (ReadAndUnReadMessageList readAndUnReadMessageList: readAndUnReadMessageLists) {
            friendIdLists.add(readAndUnReadMessageList.getFriendId());
        }
        List<User> userLists = userService.selectPhotoByList(friendIdLists);
        for (i = 0; i < userLists.size(); i++) {
            readAndUnReadMessageLists.get(i).setFriendPhoto(userLists.get(i).getPhoto());
        }
        return readAndUnReadMessageLists;
    }

    @Override
    public List<UnReadMessageList> unReadMessageList(int userId) {
        return messageMapper.selectUnReadMessageList(userId);
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
