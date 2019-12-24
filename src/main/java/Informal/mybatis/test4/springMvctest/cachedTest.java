package Informal.mybatis.test4.springMvctest;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("Cache")
public class cachedTest {
    @Autowired
    private UserService userService;
    @RequestMapping("Cache1")
    public void cache1(){
        User user=userService.selectByPrimaryKey(10);
        System.out.println(user);
        User user1=userService.selectByPrimaryKey(10);
        System.out.println(user1);

    }
}
