package Informal.mybatis.Service.Impl;

import Informal.mybatis.Dao.OrdersMapper;
import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.Orders;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserServiceNew;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceNewImpl implements UserServiceNew {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Map deleteSome(List<Integer> list) {
        Map<String,Object> map=new HashMap<>();
        User user=(User)SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            map.put("result","0");
        }
        else{
            for(int i=0;i<list.size();i++){
                List<Orders> orders=ordersMapper.selectAll();
                for(Orders orders1:orders){
                    if(list.get(i).equals(orders1.getUserId())){
                        System.out.println(list.get(i));
                        list.remove(list.get(i));
                    }

                }
            }
            map.put("result",list);
            for(int j=0;j<list.size();j++){
                userMapper.deleteByPrimaryKey(list.get(j));
            }
        }
        System.out.println(map.get("result"));
        return map;
    }

    @Override
    public String searchOrders(Model model, Integer id) {
        List<Orders> list=ordersMapper.selectByUserId(id);
        model.addAttribute("orders",list);
        return "orders";
    }
}
