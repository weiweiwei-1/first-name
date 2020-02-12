package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.ShiroException.NullAccountException;
import Informal.mybatis.Controller.ShiroException.NullCredentialsException;
import Informal.mybatis.Controller.Warning.LoginAndRegisterResult;
import Informal.mybatis.Model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/ChatPage")
public class LoginController {

    @RequestMapping(value="/login", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map login3(User user){
        Map<String, String> map = new HashMap<>();
        //只要输入就不为空，只是空字符
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(),user.getPassword());
        try {
            subject.login(token);
        } catch (NullAccountException nae) {
            map.put("NullAccountError", LoginAndRegisterResult.NULL_EMAIL_ERROR);
            return map;
        } catch (UnknownAccountException uae) {
            map.put("UnknownAccountError", LoginAndRegisterResult.EMAIL_NOTEXIST_ERROR);
            return map;
        } catch (NullCredentialsException nce) {
            map.put("NullCredentialsError", LoginAndRegisterResult.NULL_PASSWORD_ERROR);
            return map;
        } catch (IncorrectCredentialsException ice) {
            map.put("IncorrectCrdentialsError", LoginAndRegisterResult.PASSWORD_ERROR);
            return map;
        }
        User successUser = UserUtils.getUserVo();
        Session session = subject.getSession();
        session.setAttribute("id",successUser.getId());
        System.out.println(session.getAttribute("id"));
        return map;
    }
}
