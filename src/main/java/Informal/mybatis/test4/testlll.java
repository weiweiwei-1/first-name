package Informal.mybatis.test4;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testlll {
    public static void main(String args[]){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        UserService userService=(UserService)ac.getBean("userServiceImpl");
        User user=userService.selectByPrimaryKey(2);
        System.out.println(user);
    }
}
