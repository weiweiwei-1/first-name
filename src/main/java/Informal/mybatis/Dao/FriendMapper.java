package Informal.mybatis.Dao;

import Informal.mybatis.Model.Friend;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface FriendMapper {
    List<Friend> selectFriendList(Friend friend);
    List<Friend> selectFriendListById(int userId);
    Friend selectByIdAndUserId(@Param("id")int id, @Param("userId")int userId);
    Friend selectFriendUnion(Friend friend);
    Friend selectFriendOr(Friend friend);
    Friend selectFriendById(int id);
    int insertFriend(Friend friend);
    int updateFriendMark(Friend friend);
    int updateUserMark(Friend friend);
    int updateFriendMarkById(@Param("id")int id,@Param("userId")int userId,@Param("friendMark")String friendMark);
    int updateUserMarkById(@Param("id")int id,@Param("userId")int userId,@Param("friendMark")String friendMark);
    int deleteFriend(Friend friend);
    int deleteUser(Friend friend);
    int deleteFriendById(int id);
    Friend judgeUserIdPosition(Friend friend);
    Friend judgeFriend(Friend friend);
}
