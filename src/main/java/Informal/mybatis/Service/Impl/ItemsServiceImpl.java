package Informal.mybatis.Service.Impl;

import Informal.mybatis.Convert.IntegerToString;
import Informal.mybatis.Dao.ItemsMapper;
import Informal.mybatis.Model.Items;
import Informal.mybatis.Service.ItemsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> selectAll() {
        return itemsMapper.selectAll();
    }

    @Override
    public List<Items> selectLike(String condition) {
        return itemsMapper.selectLike(condition);
    }

    @Override
    public String updateMap(Map<String, String> map) {
        return null;
    }

    @Override
    public String addMap(@ModelAttribute Map<String, String> map,Model model) {
        /*id not null int
        name not null char
        price not null float
        detail String
        pic null char
        createtime null date*/

        String id1=map.get("id").trim();
        String name=map.get("name").trim();
        String price=map.get("price").trim();
        String detail=map.get("detail").trim();
//        String pic=map.get("pic").trim();
        String createtime=map.get("createtime").trim();
        String id_error;
        String name_error;
        String price_error;
        String createtime_error;
        Items items=new Items();
        if(StringUtils.isBlank(id1)){
            id_error="id不能为空";
            model.addAttribute("id_error",id_error);
        }
        if(!StringUtils.isBlank(id1)){
            IntegerToString integerToString=new IntegerToString();
            if(!integerToString.Stringforint(id1)){
                id_error="id必须为整数类型";
                model.addAttribute("id_error",id_error);
            }
            else{
                int id=Integer.parseInt(id1);
                if(id<0||id>5000)
                {
                    id_error="id必须大于0并且小于等于5000";
                    model.addAttribute("id_error",id_error);
                }
                else{
                    items.setId(id);
                }
            }
        }
        if(StringUtils.isBlank(name)){
            name_error="名字不能为空";
            model.addAttribute("name_error",name_error);
        }



        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Items items) {
        return itemsMapper.updateByPrimaryKeySelective(items);
    }

    @Override
    public Items selectByPrimaryKey(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }
}
