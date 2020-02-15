package Informal.mybatis.Controller.Base;

import Informal.mybatis.Model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtils {

    public static int getUserSessionId(HttpServletRequest request, HttpSession session) {
        session = request.getSession(false);
        try {
            return (Integer)session.getAttribute("id");
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public static boolean isAuthenticated() {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }

    public static User getUserVo() {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            SecurityUtils.getSubject().logout();
            user = new User();
        }
        return user;
    }

    public static Integer getUserId(){
        User user = getUserVo();
        if(user == null){
            user = new User();
        }
        return user.getId();
    }

    public static String getUserName() {
    User user = getUserVo();
    if (user == null) {
        user = new User();
    }
    return user.getUsername();
    }

    public static String getPassword() {
        User user = getUserVo();
        if (user == null) {
            user = new User();
        }
        return user.getPassword();
    }

    public static String getAddress() {
        User user = getUserVo();
        if (user == null) {
            user = new User();
        }
        return user.getAddress();
    }
}