package Informal.mybatis.AjaxTest;

import Informal.mybatis.Model.User;
//import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/AjaxPackget",method={RequestMethod.GET,RequestMethod.POST}/*,produces="text/html,charset=utf-8"*/)
public class AjaxPackget {

    @RequestMapping(value="/jsonenter")
            public String jsonenter()
    {
        return "ajax/AjaxPackaget";
    }
/*1
@RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody User jsonObj(@RequestBody String json){
       JSONObject jsonObject=JSONObject.fromObject(json);
       System.out.println(jsonObject.get("username"));
       User user=(User)JSONObject.toBean(jsonObject,User.class);
       return user;
}
*/

   /*2  @RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
//    如果不加@ResponseBody直接返回，将会直接返回一个页面，报404错误
    public @ResponseBody String jsonObj(@RequestBody String json){
        JSONObject jsonObject=JSONObject.fromObject(json);
        System.out.println(jsonObject.get("username"));
        String jsonString=jsonObject.toString();
        System.out.println(jsonString);
        return jsonObject.get("username").toString();*/

        /*3 @RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
        public @ResponseBody String jsonObj(@RequestBody String json){
            JSONObject jsonObject=JSONObject.fromObject(json);
            System.out.println(jsonObject.get("username"));
            String jsonString=jsonObject.toString();
            System.out.println(jsonString);
            return jsonString;*/

           /* 4 @RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
            public @ResponseBody User jsonObj(String username,String address){
                User user=new User();
                user.setUsername(username);
                user.setAddress(address);
                System.out.println(user.getUsername());
                System.out.println(user.getAddress());
                return user;*/
           /*5 @RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
           public @ResponseBody Map jsonObj(User user*//*这里不能用map*//*){
               Map<String,String> map=new HashMap<String,String>();
               System.out.println(user.getUsername());
               map.put("username",user.getUsername());
               map.put("address",user.getAddress());
               return map;*/

           @RequestMapping(value="/jsonObj",method={RequestMethod.GET,RequestMethod.POST})
           public @ResponseBody User jsonObj(User user/*或者String username String address*/){
               System.out.println(user.getUsername());
               String s="我";
               System.out.println(s);
               return user;
    }


}
