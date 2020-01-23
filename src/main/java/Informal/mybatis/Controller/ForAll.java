package Informal.mybatis.Controller;

import Informal.mybatis.Controller.ShiroException.NullAccountException;
import Informal.mybatis.Controller.ShiroException.NullCredentialsException;
import Informal.mybatis.Controller.Warning.LoginAndRegisterResult;
import Informal.mybatis.Judge.Judge;
import Informal.mybatis.Model.Items;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.ItemsService;
import Informal.mybatis.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*jsp的页面中，就是submit会有一个跳转，页面会刷新；
而button不会刷新，就是一个button；可以用
<button type="submit/button/reset"></button>
        来生成按钮，更加灵活，样式更好控制。*/
@Controller
@RequestMapping("/ForAllList")
public class ForAll {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/ForUserAndItems", method = {RequestMethod.GET, RequestMethod.POST})
    public String ForUserAndItems(Model model) {
        List<User> user = userService.selectAll();
        List<Items> items = itemsService.selectAll();
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
        System.out.println("当前用户为：" + user1);
        System.out.println("当前session为：");
        Session session = subject.getSession();
        System.out.println("session的主机地址为" + session.getHost());
        System.out.println("session的id为" + session.getId());
        if (subject.isAuthenticated()) {
            Judge judge = new Judge();
            List<User> user2 = userService.selectAll();
            if (!judge.isContain(user1, user2)) {
                subject.logout();
                session.touch();
                session.stop();
                String logininfo = "请登录";
                String register = "没有账号？请注册";
                model.addAttribute("logininfo", logininfo);
                model.addAttribute("register", register);
            } else {
                User user3 = userService.selectByName(user1.getUsername());
                model.addAttribute("user", user3);
                model.addAttribute("username", user3.getUsername());
            }
        } else {
            String logininfo = "请登录";
            String register = "没有账号？请注册";
            model.addAttribute("logininfo", logininfo);
            model.addAttribute("register", register);
        }
        model.addAttribute("userList", user);
        model.addAttribute("itemsList", items);
        return "newUser";
    }

    @Transactional
    @RequestMapping(value = "/searchforall", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map searchforall(@RequestParam String condition) {
        List<User> users = userService.selectLike(condition);
        List<Items> items = itemsService.selectLike(condition);
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);
        map.put("items", items);
        System.out.println(users);
        return map;
    }

    @RequestMapping("/backtotable")
    public String backtotable() {
        return "forward:ForUserAndItems";
    }

    @RequestMapping(value = "/forregister", method = {RequestMethod.GET, RequestMethod.POST})
    public String forregister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> register(String username, String address, String sureAddress) {
        Map<String, String> map = new HashMap<>();
        String usernameError = null;
        String addressError = null;
        String sureAddressError = null;
        String Symbol = "1";
        if (StringUtils.isBlank(username)) {
            usernameError = LoginAndRegisterResult.NULL_USERNAME_ERROR;
            Symbol = "0";
        } else if (userService.selectByName(username) != null) {
            usernameError = LoginAndRegisterResult.USERNAME_EXIST_ERROR;
            Symbol = "0";
        }
        if (StringUtils.isBlank(address)) {
            addressError = LoginAndRegisterResult.NULL_PASSWORD_ERROR;
            Symbol = "0";
        } else if (address.length() < 4) {
            addressError = LoginAndRegisterResult.PASSWORD_FORMAT_ERROR;
            Symbol = "0";
        } else if (!sureAddress.equals(address)) {
            sureAddressError = LoginAndRegisterResult.PASSWORD_CONFIRM_ERROR;
            Symbol = "0";
        }
        if (Symbol.equals("0")) {
            map.put("usernameError", usernameError);
            map.put("addressError", addressError);
            map.put("sureAddressError", sureAddressError);
            map.put("Symbol", Symbol);
        } else {
            map.put("Symbol", Symbol);
            try {
                User user = new User();
                user.setUsername(username);
                user.setAddress(address);
                userService.insert(user);
                SecurityUtils.getSubject().login(new UsernamePasswordToken(username, address));
            } catch (Exception e) {
                map.remove("Symbol", Symbol);
                Symbol = "2";
                map.put("Symbol", Symbol);
            }
        }
        return map;
    }



    @RequestMapping(value="/forlogin")
    public String forlogin(){
        return "login";
    }

    @RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map login3(User user){
        Map<String, String> map = new HashMap<>();
        //只要输入就不为空，只是空字符
        System.out.println(user.getUsername());
        System.out.println(user.getAddress());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getAddress());
        try {
            subject.login(token);
        }catch (NullAccountException nae) {
            map.put("NullAccountError", LoginAndRegisterResult.NULL_USERNAME_ERROR);
            return map;
        }catch (UnknownAccountException uae) {
            map.put("UnknownAccountError", LoginAndRegisterResult.USERNAME_ERRROR);
            return map;
        }catch (NullCredentialsException nce) {
            map.put("NullCredentialsError", LoginAndRegisterResult.NULL_PASSWORD_ERROR);
        }catch (IncorrectCredentialsException ice) {
            map.put("IncorrectCrdentialsError", LoginAndRegisterResult.PASSWORD_ERROR);
        }
        return map;
    }

    @RequestMapping(value="/UpdateInformationPage",method={RequestMethod.GET,RequestMethod.POST})
    public String UpdateInformationPage(Model model,String username){
        System.out.println(username);
        System.out.println("测试");
        User user1=userService.selectByName(username);
        System.out.println(user1);
        model.addAttribute("user",user1);
        return "reupdate";
    }

    @RequestMapping(value="/submitReupdate",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,String> submitReupdate(String birthday, String sex, String address) throws Exception{
        return userService.reupdate(birthday,sex,address);
    }

    @RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
        public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        Session session=subject.getSession();
        System.out.println("logout的session的id为："+ session.getId());
        session.stop();
        return "forward:ForUserAndItems";
    }

    @RequestMapping(value="/forupdateaddress",method={RequestMethod.GET,RequestMethod.POST})
    public String forupdateaddress(Model model){
        User user=(User)SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        if(user==null){
            return "login";
        }
        User user1=userService.selectByPrimaryKey(user.getId());
        model.addAttribute("user",user1);
        return "updateaddress";
    }

    @RequestMapping(value="/updateaddress",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,String> updateaddress(String address,String newaddress,String sureaddress){
        String result;
        Map<String,String> map=new HashMap<>();
        String addresserror;
        String newaddresserror;
        String sureaddresserror;
        String right;
        User user=(User)SecurityUtils.getSubject().getPrincipal();
    if(!user.getAddress().equals(address)){
            addresserror="原地址错误";
            result="0";
            map.put(result,addresserror);
            System.out.println("原地址错误");
        }
        else if(StringUtils.isBlank(newaddress)||newaddress.length()<4){
        result="1";
        newaddresserror="新的地址太短或者为空";
        map.put(result,newaddresserror);
    }
    else if(!newaddress.equals(sureaddress)){
        result="2";
        sureaddresserror="前后地址不相同";
        map.put(result,sureaddresserror);
    }
    else{
       User user1=new User();
       user1.setId(user.getId());
       user1.setAddress(newaddress);
       user.setAddress(newaddress);
       userService.updateByPrimaryKeySelective(user1);
       result="3";
       right="登录成功";
       map.put(result,right);
    }
    return map;
    }
    /*@RequestMapping(value="newWindow",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> newWindow(String username) throws{
        String result;
        Map<String,Object> map=new HashMap<>();
        return map;

    }*/
}

