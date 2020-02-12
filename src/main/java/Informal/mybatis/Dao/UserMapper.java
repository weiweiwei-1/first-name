package Informal.mybatis.Dao;

import Informal.mybatis.Model.Orders;
import Informal.mybatis.Model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
public interface UserMapper {
    int insert(User user);
    int insertSelective(User user);
    int insertReplace(User user);
    int insertMap(Map<String,Object> map);
    //因为是插入多条记录，所以是用List来表示User
    int InsertManyforeach(List<User> user);
    int deleteByPrimaryKey(Integer id);
//    mybatis传入参数，@Param("a")和@Param("b")对应映射文件的传入的参数
    int deleteByData(@Param("a")Integer a, @Param("b")Integer b);
    int updateByPrimaryKey(User user);
    int updateByPrimarykeySelective(User user);
    User selectByPrimaryKey(Integer id);
    User selectByObject(User user);
    List<User> selectLike(Map<String,String> map);
    List<User> selectLikeObject(Map<String,String> map);
    List<User> selectLikeParam(@Param("param") String object);
    User selectByName(@Param("name")String name);
    User selectByEmail(@Param("email")String email);
    User selectTwoproperties(User user);
    List<User> selectAll();
    List<User> selectForeachList(List<Integer> id);
    List<User> selectFriendPhoto(List<Integer> id);
    List<User> selectForeachArray(@Param("mingzi")String []names);
    //用了@Param,collection里面的array或者list可以用Param参数代替
    List<User> selectForeachMap(Map<String,Object> map);   //这里用了map传参，定义了多种类型的数据，非常灵活
    List<User> selectChoose(User user);
    String selectUserNameById(int userId);
}
