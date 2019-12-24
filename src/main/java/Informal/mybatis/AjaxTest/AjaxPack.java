package Informal.mybatis.AjaxTest;
import Informal.mybatis.Model.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/******注意，produces里面的方法是定义返回的类型，
如果返回json类型数据，必须说明为application/json，否则返回失败*/
@Controller
@RequestMapping(value="/AjaxPack",method={RequestMethod.GET,RequestMethod.POST},produces="text/html;charset=UTF-8")
public class AjaxPack{
    @RequestMapping("/enterpack")
    public String enterpack(){
        return "ajax/AjaxPackage";
    }
    @RequestMapping(value="/urlget",method={RequestMethod.GET,RequestMethod.POST},produces="application/json;charset=UTF-8")
//    这里必须要加 @ResponseBody，将返回的类转换为json类，否则不能返回json类型数据
    public @ResponseBody User urlget(HttpServletRequest request, HttpServletResponse response,String name, String password) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name1",name);
        map.put("password1",password);
        User user=new User();
      /*  //      将map类型转换成json字符串,然后将json字符串返回给前端,前端将字符串转化为json对象,成功
        System.out.println(map.get("name1"));
        String json=JSONObject.toJSONString(map);
        return json;*/

 //      第二种方法，加@ResponseBody，将返回的对象转换为json对象，直接通过json里面的key值调用value属性,
// 但是produces返回类型必须指定application/json,成功,
//        toString将object类型转为string类型
        user.setUsername(map.get("name1").toString());
        return user;

/*// 第三种方法，将map对象转换为json对象，返回，但是还是必须得返回json类型，要加@ResponseBody注解，
//返回String不用加@Reponsebody注解,最常用的第二种方法
        JSONObject jsonObject=new JSONObject(map);
        return jsonObject;*/

    }
}
