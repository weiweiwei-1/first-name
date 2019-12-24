package Informal.mybatis.Dao;

import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.enty.FriendChatList;
import Informal.mybatis.Model.enty.UnReadMessageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int insertMessage(Message message);
    List<Message> selectMessages(Message message);
    List<UnReadMessageList> selectUnReadMessageList(int userId);
    Message selectByIdAndUserId(@Param("id")int id, @Param("userId")int userId);
    int deleteMessages(Message message);
    int deleteMessageById(int id);
    int deleteMessageByIdAndSenderId(@Param("id")int id,@Param("senderId")int senderId);
    Message selectLastUnReadMessage(Message message);
    List<FriendChatList> frendChatList(int userId);
    int deleteAllMessages(Message message);
    int withDrawUserMessages(Message message);
}
