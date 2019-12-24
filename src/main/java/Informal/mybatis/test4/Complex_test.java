package Informal.mybatis.test4;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Complex_test {
    private User user;
    private UserService userService;

    @Before
    public void setUp(){
        user = new User();
        ApplicationContext ac = new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        userService = (UserService) ac.getBean("userServiceImpl");
    }

    @Test
    public void updateByPrimaryKey() {
        user.setId(12);
        user.setUsername("威少小威");
//        user.setSex("女");
        user.setAddress("广东");
        userService.updateByPrimaryKey(user);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        user.setId(10);
        user.setSex("");
//        当限定条件不为null执行时，“”也会不为空，字段执行，当“”插入数据库时，数据库相应的字段显示空符号，但是不会显示null
        user.setAddress("");
        userService.updateByPrimaryKeySelective(user);
    }

    @Test
    public void insert(){
        user.setId(55);
        user.setUsername("zhangxiangrui");
        user.setAddress("合肥");
        user.setSex("");
        userService.insert(user);
    }

    @Test
    public void selectLike(){
        List<User> user=userService.selectLike(null);
        for(User usero:user){
            System.out.println(usero);
        }
    }

    @Test
    public void selectAll(){
        List<User> user=userService.selectAll();
        for(User usero:user){
            System.out.println(usero);
        }
    }

@Test
    public void insertMap(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",3);
        map.put("username","曾威威");
        map.put("sex","男");
        map.put("address","meizhou");
        userService.insertMap(map);
}

@Test
    public void putong(){
        System.out.println("我是");
}


}
