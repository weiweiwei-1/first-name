package Informal.mybatis.Service;


import Informal.mybatis.Model.User;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//@Service
public interface UserService {
    int updateByPrimaryKey(User user);
    int updateByPrimaryKeySelective(User user);
    int deleteByPrimaryKey(Integer id);
    int insert(User user);
    int insertSelective(User user);
    int insertMap(Map<String,Object> map);
    User selectByPrimaryKey(Integer id);
    List<User> selectLike(String object);
    User selectByName(String name);
    List<User> selectAll();
    String addUser(Map<String,String> user) throws Exception;
    String submitUser(Map<String, String> map, Integer id) throws Exception;
    Map<String,String> reupdate(String birthday, String sex, String address) throws Exception;
}
