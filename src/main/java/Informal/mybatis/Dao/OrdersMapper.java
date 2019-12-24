package Informal.mybatis.Dao;

import Informal.mybatis.Model.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdersMapper {
    Orders selectByPrimaryKey(Integer id);
    List<Orders> selectLike(String condition);
    List<Orders> selectAll();
    List<Orders> selectByUserId(Integer id);
//    int insert(Orders orders);
    int insertSelective(Orders orders);
//    int insertMapSelective(Map<String ,String> map);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(Orders orders);
    int updateByPrimaryKeySelective(Orders orders);
//    int updateByPrimaryKeyMapSelective(Orders orders);
}
