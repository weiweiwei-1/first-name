package Informal.mybatis.test4.Spring_can_test;

import Informal.mybatis.Service.Impl.UserServiceImpl;
import Informal.mybatis.Service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User_Test {
    @Autowired
    UserService userService;

}
