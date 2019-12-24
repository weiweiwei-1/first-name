package Informal.mybatis.AjaxList;

import Informal.mybatis.Model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/ajaxList",method={RequestMethod.GET,RequestMethod.POST})
public class AjaxList {
    @RequestMapping(value="/listEnter"/*,method={RequestMethod.GET,RequestMethod.POST}*/)
    public String listEnter(){
        return "ajaxList/ajaxList";
    }
    @RequestMapping(value="/Listtry",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//可以用RequestBody注解传参
    public List Listtry(@RequestBody List<User> list){
        JSONArray jsonArray=JSONArray.fromObject(list);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            System.out.println(jsonObject.get("username"));
        }
List<User> users=(List<User>)JSONArray.toCollection(jsonArray,User.class);
        System.out.println(users);
        return users;
    }

}
