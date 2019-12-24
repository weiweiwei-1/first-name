package Informal.mybatis.Controller;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.ItemsService;
import Informal.mybatis.Service.UserService;
//import com.alibaba.druid.util.StringUtils;
import Informal.mybatis.Service.UserServiceNew;
import Informal.mybatis.validatorgroups.AddValidator;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//注意在分层结构中，控制层调用业务层，业务层调用持久层，这样可以提高Service层的可复用性，减少代码量。
@Controller
@RequestMapping("/usernewList")
public class UserNewController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceNew userServiceNew;

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/toUpdateUser", method = {RequestMethod.POST, RequestMethod.GET})
    public String editUsers(Model model, @RequestParam("id") Integer id) throws Exception {
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @RequestMapping("/submitUser")
//    下面的方法进行了参数绑定，如果没有日期类型没有自定义参数绑定，那么将会出错
    public String submitUser(@RequestParam Map<String, String> map, @RequestParam("id") Integer id/* User user*/) throws Exception {
        return userService.submitUser(map,id);

    }


    //    refirect不提交修改后的数据，forward可以保存提交后的数据，重定向后，可以显示新的数据
    @RequestMapping("/deleteuser")
    public String deleteuser(Integer id,User user) throws Exception {
        user=(User)SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        if(id==user.getId()){
            return "delete-info";
        }
        else {
            userService.deleteByPrimaryKey(id);
            return "delete-success";
        }
    }

    @RequestMapping("/add")
    //显示的是空白的页面，可以不接受参数，可以不传入数据到页面，参数绑定也是如此
    public String add() throws Exception {
        return "addUser";
    }

    //这里用的是校验器，不用校验器，在Service层也是可以校验
    @RequestMapping(value = "/addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String addUser(@ModelAttribute @Validated(value={AddValidator.class}) User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            FieldError id=bindingResult.getFieldError("id");
            FieldError username=bindingResult.getFieldError("username");
            FieldError birthday=bindingResult.getFieldError("birthday");
            FieldError address=bindingResult.getFieldError("address");
            if(id!=null){
                String id_error=id.getDefaultMessage();
                model.addAttribute("id_error",id_error);
            }
            if(username!=null){
                String username_error=username.getDefaultMessage();
                model.addAttribute("username_error",username_error);
            }
            if(birthday!=null){
                String birthday_error=birthday.getDefaultMessage();
                model.addAttribute("birthday_error",birthday_error);
            }
            if(address!=null){
                String address_error=address.getDefaultMessage();
                model.addAttribute("address_error",address_error);
            }
            model.addAttribute("user",user);
            return "addUser";
        }
        List<User> user1=userService.selectAll();
        for(User user2:user1){
            if(user.getId().equals(user2.getId())){
                return "info";
            }
        }
            userService.insertSelective(user);
            return "success";

    }

    @RequestMapping(value = "/eidtAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(Model model) throws Exception{
        List<User> list = userService.selectAll();
        //注意，如果参数传值对不上，将会报404错误
        model.addAttribute("userList", list);
        return "editAllUser";
    }

    @RequestMapping(value = "/post", method = {RequestMethod.GET, RequestMethod.POST})
    public String post(User user,Integer id) {
        user.setId(id);
        userService.updateByPrimaryKeySelective(user);
        return "newUser";
    }

    @RequestMapping("/deleteSome")
    @ResponseBody
    public Map deleteSome(@RequestBody List<Integer> list) throws Exception{
       Map<String,Object> map=userServiceNew.deleteSome(list);
       return map;
    }

    @RequestMapping(value="searchOrders",method={RequestMethod.GET,RequestMethod.POST})
    public String searchOrders(Model model,Integer id){
        return userServiceNew.searchOrders(model,id);
    }
}
