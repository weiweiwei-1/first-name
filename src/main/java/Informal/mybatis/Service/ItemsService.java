package Informal.mybatis.Service;

import Informal.mybatis.Model.Items;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface ItemsService {
    List<Items> selectAll();
    List<Items> selectLike(String condition);
    Items selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Items items);
    String updateMap(Map<String,String> map);
    String addMap(Map<String,String> map,Model model);
}
