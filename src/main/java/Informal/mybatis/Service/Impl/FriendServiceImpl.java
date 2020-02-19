package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.MessageMapper;
import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.Message;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Friend> showFriendList(int userId) {
        List<Integer> list = new ArrayList<>();
        List<Friend> friendLists = friendMapper.selectFriendListById(userId);
        for(Friend friend: friendLists) {
            list.add(friend.getFriendId());
        }
        List<User> userLists = userMapper.selectMainUserList(list);
        try {
            for (int i = 0; i < friendLists.size(); i++) {
                friendLists.get(i).setFriendPhoto(userLists.get(i).getPhoto());
                friendLists.get(i).setFriendSchool(userLists.get(i).getSchool());
                friendLists.get(i).setFriendCompany(userLists.get(i).getCompany());
                friendLists.get(i).setFriendUserName(userLists.get(i).getUsername());
            }
            System.out.println(friendLists);
            return friendLists;
        } catch (IndexOutOfBoundsException e) {
            return new ArrayList<Friend>();
        }

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
