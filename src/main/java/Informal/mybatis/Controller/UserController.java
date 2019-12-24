package Informal.mybatis.Controller;


import Informal.mybatis.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


/*public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> list=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setAddress("meihzou");
        user1.setSex("nan");
        user1.setUsername("weishao");
        User user2=new User();
        user2.setId(2);
        user2.setAddress("meihzou2");
        user2.setSex("nan2");
        user2.setUsername("weishao2");
        User user3=new User();
        user3.setId(3);
        user3.setAddress("meihzou3");
        user3.setSex("nan3");
        user3.setUsername("weishao3");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemList",list);
        modelAndView.setViewName("WEB-INF/Jsp/user.jsp");
        return modelAndView;
    }
}*/
@Controller
@RequestMapping("/usero")
public class UserController{
    @RequestMapping("/itemlist")
    public ModelAndView queryItems() throws Exception{
        List<User> list=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setAddress("meihzou");
        user1.setSex("nan");
        user1.setUsername("weishao");
        User user2=new User();
        user2.setId(2);
        user2.setAddress("meihzou2");
        user2.setSex("nan2");
        user2.setUsername("weishao2");
        User user3=new User();
        user3.setId(3);
        user3.setAddress("meihzou3");
        user3.setSex("nan3");
        user3.setUsername("weishao3");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemList",list);
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
