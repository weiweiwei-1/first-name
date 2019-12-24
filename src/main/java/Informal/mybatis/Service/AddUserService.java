package Informal.mybatis.Service;

import Informal.mybatis.Model.AddUser;

import java.util.List;

public interface AddUserService {
    int sendAddUserApplication(int beAddId,int userId,String addName);
    int permitAddUser(int userId,int addId,String addName);
    int permitAddUserById(int id,int userId,String addName);
    List<AddUser> showAddUserList(int userId);
    int rejectAddUser(int userId,int addId);
    int rejectAddUserById(int id,int userId);
}
