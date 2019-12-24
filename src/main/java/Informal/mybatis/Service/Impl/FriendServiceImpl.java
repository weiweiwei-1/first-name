package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.MessageMapper;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Friend> showFriendList(int userId) {
        return friendMapper.selectFriendListById(userId);
    }

    @Override
    public int deleteFriend(int userId, int friendId) {
        Friend friend=new Friend(userId,friendId);
        Friend confirmFriend=friendMapper.selectFriendUnion(friend);
        Message message=new Message(userId,friendId);
        if(confirmFriend!=null){
            if(confirmFriend.getUserId()==userId){
                messageMapper.deleteAllMessages(message);
                return friendMapper.deleteFriend(friend);
            }else{
               friend.changePosition();
                messageMapper.deleteAllMessages(message);
                return friendMapper.deleteFriend(friend);
            }
        }
            return 0;

    }

    @Override
    public int deleteFriendById(int id,int userId) {
        Friend friendBase=friendMapper.selectByIdAndUserId(id,userId);
        if(friendBase!=null){
            Message message=new Message(userId,friendBase.getFriendId());
            messageMapper.deleteAllMessages(message);
            return friendMapper.deleteFriendById(id);
        }
            return 0;

    }

    @Override
    public int updateFriendMark(int userId, int friendId,String friendMark) {
        Friend friendBase=new Friend(userId,friendId);
        friendBase.setFriendMark(friendMark);
        Friend friend=friendMapper.selectFriendUnion(friendBase);
        if(friend!=null){
            if(friend.getUserId()==userId){
                return friendMapper.updateFriendMark(friendBase);
            }else{
                return friendMapper.updateUserMark(friendBase);
            }
        }else{
            return 0;
        }
    }

    @Override
    public int updateFriendMarkById(int id, int userId,String friendMark) {
        Friend friend=friendMapper.selectByIdAndUserId(id,userId);
        if(friend!=null){
            if(friend.getUserId()==userId){
                return friendMapper.updateFriendMarkById(id,userId,friendMark);
            }else{
                return friendMapper.updateUserMarkById(id,userId,friendMark);
            }
        }
        return 0;
    }


    @Override
    public List<Friend> searchFriend(String keyCondition) {
        return null;
    }
}
