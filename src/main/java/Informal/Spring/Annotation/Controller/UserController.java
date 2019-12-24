package Informal.Spring.Annotation.Controller;

import Informal.Spring.Annotation.Dao.UserDao;
import Informal.Spring.Annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //    实现了两个接口，就要指定是哪个接口,qualifier默认是类的首字母小写，如果指定值，需要注明(value可以不写)
    @Autowired
    @Qualifier(value="userServiceImpl2")
    private UserService userService;
    @Value("3")
    private int a;
    public void InsertTest(){
        userService.insertsomething(a);
    }
}
