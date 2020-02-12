package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.EmailCode;
import Informal.mybatis.Controller.Base.RandomName;
import Informal.mybatis.Controller.ExtrateOperate.EmailOperate;
import Informal.mybatis.Controller.Warning.LoginAndRegisterResult;
import Informal.mybatis.Convert.EmailFormatCheck;
import Informal.mybatis.Convert.MailValid;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/ChatPage")
public class RegisterController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/sendCode", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String sendCode(String email){
        System.out.println("验证码为：" + EmailCode.getEmailCode.get(email));
        if (!EmailFormatCheck.isEmail(email)) {
            return LoginAndRegisterResult.EMAIL_FORMAT_ERROR;
        } else if (!MailValid.validEmail(email,"weichat.online")){
            return LoginAndRegisterResult.EMAIL_NOTEXIST_ERROR;
        } else if (userService.selectByEmail(email) != null) {
            return LoginAndRegisterResult.EMAIL_EXIST_ERROR;
        } else if (EmailCode.getEmailCode.get(email) != null){
            return LoginAndRegisterResult.EMAIL_CONFIRMCODE_EXIST_ERROR;
        } else {
            return EmailOperate.sendEmail(email);
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> register(String email, String password, String confirmCode) {
        Map<String, String> map = new HashMap<>();
        String emailError = null;
        String passwordError = null;
        String confirmCodeError =  null;
        String Symbol = "1";
        if (EmailCode.getEmailCode.get(email) == null) {
            Symbol = "0";
            emailError = LoginAndRegisterResult.EMAIL_AND_CODE_ERROR;
        } else if (!confirmCode.equals(EmailCode.getEmailCode.get(email))) {
            Symbol = "0";
            confirmCodeError = LoginAndRegisterResult.EMAIL_CODE_ERROR;
        } else if (userService.selectByEmail(email) != null) {
            Symbol = "0";
            confirmCodeError = LoginAndRegisterResult.EMAIL_EXIST_ERROR;
        }
        if (password.length() < 4 || 16 < password.length()) {
            Symbol = "0";
            passwordError = LoginAndRegisterResult.EMAIL_FORMAT_ERROR;
        }
        if (Symbol.equals("0")) {
            map.put("Symbol", Symbol);
            map.put("emailError", emailError);
            map.put("passwordError", passwordError);
            map.put("confirmCodeError", confirmCodeError);
        } else {
            map.put("Symbol", Symbol);
            try {
                User user = new User();
                user.setEmail(email);
                user.setUsername(RandomName.getRandomName());
                user.setPassword(password);
                user.setPhoto("originImg.jpg");
                userService.insertSelective(user);
            } catch (Exception e) {
                map.remove("Symbol", Symbol);
                Symbol = "2";
                map.put("Symbol", Symbol);
            }
        }
        return map;
    }
}
