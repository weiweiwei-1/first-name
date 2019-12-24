package Informal.Spring.Annotation.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserResource {
    /*@Resource(name="user")
    Resource只能注入其他bean的id，name指定bean的id，或者直接autowired也可以*/
    @Autowired
   private User user;
    public void information(){
        user.information();
    }
}
