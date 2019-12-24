package Informal.mybatis.Dao;

import Informal.mybatis.Model.AddUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddUserMapper {
    int insertAddUser(AddUser addUser);
    List<AddUser> selectAddUserByUserId(int userId);
    AddUser selectByBothId(AddUser addUser);
    AddUser selectByIdAndBeAddId(@Param("id")int id, @Param("beAddId")int beAddId);
    AddUser selectAddUserById(int id);
    int deleteAddUser(AddUser addUser);
    int deleteAddUserById(int id);
}
