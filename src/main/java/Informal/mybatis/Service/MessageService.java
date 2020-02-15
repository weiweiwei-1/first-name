package Informal.mybatis.Service;

import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.enty.ReadAndUnReadMessageList;
import Informal.mybatis.Model.enty.UnReadMessageList;

import java.util.List;

public interface MessageService {
    int sendMessage(int userId,int friendId,String content);
    int sendAllMessage(Message message);
    List<Message> selectAllMessages(int userId, int friendId);
    int readMessages(int userId, int friendId);
    List<ReadAndUnReadMessageList> readAndUnReadMessageList(int userId);
    List<UnReadMessageList> unReadMessageList(int userId);
    int deleteMessages(int userId,int friendId);
    int deleteMessageById(int id,int userId);
    int deleteAllMessages(int userId,int friendId);
}
