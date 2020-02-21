package Informal.mybatis.Service;

import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.enty.FriendChatList;

import java.util.List;

public interface FriendService {
    List<Friend> showFriendList(int userId);
    Friend selectFriendMark(Friend friend);
    int deleteFriend(int userId,int friendId);
    int deleteFriendById(int id,int userId);
    int updateFriendMark(int userId,int friendId,String friendMark);
    int updateFriendMarkById(int id,int userId,String friendMark);
    int addFriend(Friend friend);
    List<Friend> searchFriend(String keyCondition);
}
