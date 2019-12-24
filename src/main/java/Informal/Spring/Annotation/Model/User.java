package Informal.Spring.Annotation.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
/*将@Comopnent省略，因为已经在配置文件设置了id，注入了bean,已经进入spring容器,只要在bean容器，就可以使用注解*/
public class User {
    @Value("22")
    private int age;
    @Value("曾庆威")
    private String name;
    @Value("960529")
    private String password;
    public void information(){
        System.out.println("姓名："+name+" "+"年龄："+age+" "+"密码："+password+" ");
    }
}
