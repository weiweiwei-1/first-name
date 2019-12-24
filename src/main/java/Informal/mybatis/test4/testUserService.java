package Informal.mybatis.test4;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class testUserService {
    @Autowired
   private UserService userService;
    public void testuser(){
    List<User> user=userService.selectAll();
    for(User usero:user){
        System.out.println(usero);
    }
}}
