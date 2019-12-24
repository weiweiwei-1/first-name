package Informal.mybatis.test4.Mappertest;

import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {
    private UserMapper userMapper;
    private User user;
    @Before
    public void testNumId(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        userMapper=(UserMapper)ac.getBean("userMapper");
    }
    @Test
    public void testAllMapper(){
        List<User> user=userMapper.selectAll();
        List<Integer> list=new ArrayList<Integer>();
        for(User usero:user){
            int i=usero.getId();
            list.add(i);
//            System.out.println(usero.getId());
        }
      /*  System.out.println(user.size());
        for(int i=0;i<user.size();i++)
        {

        }*/
      for(Integer i:list){
          System.out.println(i);
      }
      for(int i=0;i<user.size();i++){
          System.out.println();
      }
    }

    @Test
    public void testselectbyname(){
        User user=userMapper.selectByName("曾庆威");
        System.out.println(user);
    }
}
