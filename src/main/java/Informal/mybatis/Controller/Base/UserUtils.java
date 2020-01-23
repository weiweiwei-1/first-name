package Informal.mybatis.Controller.Base;

import Informal.mybatis.Model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserUtils {

    public static boolean isAuthenticated() {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }

    private static User getUserVo() {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            SecurityUtils.getSubject().logout();
        }
        return user;
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