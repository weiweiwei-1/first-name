package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.AddUserMapper;
import Informal.mybatis.Dao.FriendMapper;
import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Judge.Judge;
import Informal.mybatis.Model.AddUser;
import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.AddUserService;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddUserServiceImpl implements AddUserService {
    @Autowired
    private Judge judge;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private AddUserMapper addUserMapper;
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public int sendAddUserApplication(int beAddId, int userId, String addName) {
        User user=userMapper.selectByPrimaryKey(beAddId);
        if(user!=null){
            AddUser addUser=new AddUser(beAddId,userId,addName);
            addUserMapper.insertAddUser(addUser);
            return addUser.getId();
        }else{
            return 0;
        }

    }

    @Override
    public List<AddUser> showAddUserList(int userId) {
        return addUserMapper.selectAddUserByUserId(userId);
    }

    @Override
    public int permitAddUser(int userId,int addId,String addName) {
        AddUser addUserBase=new AddUser(userId,addId);
        AddUser addUser=addUserMapper.selectByBothId(addUserBase);
        if(addUser!=null){
        User user=userService.selectByPrimaryKey(userId);
        Friend friend=new Friend(userId,addId,user.getUsername(),addName);
        friendMapper.insertFriend(friend);
        return addUserMapper.deleteAddUser(addUserBase);}else{
            return 0;
        }
    }

    @Override
    public int permitAddUserById(int id,int userId,String addName) {
        List<AddUser> lists=addUserMapper.selectAddUserByUserId(userId);
        if(judge.addUserIdContain(id,lists)){
            AddUser addUser=addUserMapper.selectAddUserById(id);
            User user = userService.selectByPrimaryKey(userId);
            Friend friend = new Friend(addUser.getBeAddId(), addUser.getAddId(), user.getUsername(), addName);
            friendMapper.insertFriend(friend);
            return addUserMapper.deleteAddUserById(id);}else{
            return 0;
        }
    }

    @Override
    public int rejectAddUser(int userId, int addId) {
        AddUser addUserBase=new AddUser(userId,addId);
        AddUser addUser= addUserMapper.selectByBothId(addUserBase);
        if(addUser!=null){
            return addUserMapper.deleteAddUser(addUser);
        } else{
            return 0;
        }

    }

    @Override
    public int rejectAddUserById(int id,int userId) {
        AddUser addUser = addUserMapper.selectByIdAndBeAddId(id,userId);
        if(addUser!=null){
            return addUserMapper.deleteAddUserById(id);
        }else{
            return 0;
        }
    }
}
