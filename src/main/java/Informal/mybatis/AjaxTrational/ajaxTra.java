package Informal.mybatis.AjaxTrational;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/ajaxTra",method={RequestMethod.GET,RequestMethod.POST})
public class ajaxTra {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/ajaxTenter")
    public String ajaxTenter(){
        return "ajaxT/confirm";
    }
    @RequestMapping(value="dopost",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String dopost(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String result;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String parameter=request.getParameter("username");
        if(parameter.equals("")){
            result="0";
        }
        else {
            User user = userService.selectByName(parameter);
            System.out.println(parameter);
            System.out.println(user);
            if (user == null) {
                result = "1";
            } else {
                result = "2";
            }
        }
        return result;
    }
    @RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String address=request.getParameter("address");
        System.out.println(address);
        System.out.println(username);

        String result="";
        if(username.equals("")){
            result="0";
        }
        else {
            User user=userService.selectByName(username);
            System.out.println(user);
            if (address.equals("")) {
                result = "1";
            }
            else if (address.equals(user.getAddress())) {
                result = "2";
            } else {
                result = "3";
            }
        }
        return result;
    }

    @RequestMapping(value="/login2",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map login2(User user) throws Exception{
        String result;
        String username=user.getUsername();
        System.out.println(username);
        if(username==null||username.isEmpty()){
            result="0";
        }
       else if(username.length()<3){
            result="1";
        }
        else{
            User user1=userService.selectByName(username);
            if(user1==null){
                result="2";
            }
            else result="3";
        }
       Map<String,String> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
    @RequestMapping(value="/enterregit")
    public String enterregit(){
        return "ajax/ajaxregister";
    }
    @RequestMapping(value="/ajaxRegit",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map ajaxRegit(User user,String readdress) throws Exception{
        String username=user.getUsername();
        String address=user.getAddress();
        String result="";
        if(username.isEmpty()){
            result="0";//用户名为空
        }
        else if(username.trim().length()==0){
            result="1";//用户名不能为空字符
        }
        else if(username.length()<2)
        {
            result="2";//用户名太短
        }
        else
        {
            User user1=userService.selectByName(username);
            if(user1!=null){
                result="3";//用户已经存在
            }
            else if(StringUtils.isBlank(address)){
                result="4";//地址不能为空白
            }
            else if(address.length()<6){
                result="5";//地址太短
            }
            else if(!address.equals(readdress)){
                result="6";//地址确认对不上
            }
            else{
                result="7";//成功
            }
        }
        Map<String,String> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
@RequestMapping(value="enterLogin",method={RequestMethod.GET,RequestMethod.POST})
public String enterLogin(){
        return "ajax/ajaxLogin";
}
    @RequestMapping(value="/login3")
    @ResponseBody
    public Map login3(User user) throws Exception{
        String username=user.getUsername();
        String address=user.getAddress();
        String result="";
        if(username.isEmpty()){
            result="0";//用户名不能为空
        }
        else{
            User user1=userService.selectByName(username);
            System.out.println(user1);
            if(user1==null){
                result="1";//用户不存在
            }
            else if(!address.equals(user1.getAddress())){
                result="2";//地址错误
            }
            else{
                result="3";//登录成功
            }
        }
        Map<String,String> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
    @RequestMapping(value="/enterList")
    public String enterList(){
        return "ajaxT/listShow";
    }
    @RequestMapping(value="/ajaxList",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List ajaxList(){
        List<User> user=userService.selectAll();
        JSONArray jsonArray=JSONArray.fromObject(user);//jsonarray其实是一个数组,输出jsonarray，需要将array转化为json对象
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            System.out.println(jsonObject.get("username"));
        }
        return user;
    }
}
