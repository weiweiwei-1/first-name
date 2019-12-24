package Informal.mybatis.Dao;


import Informal.mybatis.Model.Items;

import java.util.List;

public interface ItemsMapper {
    Items selectByPrimaryKey(Integer id);
    List<Items> selectLike(String condition);
    List<Items> selectAll();
    int insertSelective(Items items);
    int updateByPrimaryKey(Items items);
    int updateByPrimaryKeySelective(Items items);
    int deleteByPrimaryKey(Integer items);

}
