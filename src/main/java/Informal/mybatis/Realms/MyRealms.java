package Informal.mybatis.Realms;

import Informal.mybatis.Controller.ShiroException.NullAccountException;
import Informal.mybatis.Controller.ShiroException.NullCredentialsException;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRealms extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
//    认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String email = (String)token.getPrincipal();
        String password = String.valueOf(token.getPassword());
        System.out.println(email);
        System.out.println(password);
        if (StringUtils.isBlank(email)) {
            throw new NullAccountException("邮箱不能为空");
        } else {
            User user = userService.selectByEmail(email);
            if (user == null) {
                throw new UnknownAccountException("邮箱不存在");
            } else if (StringUtils.isBlank(password)) {
                throw new NullCredentialsException("密码不能为空");
            } else if (!password.equals(user.getPassword())) {
                throw new IncorrectCredentialsException("密码错误");
            }
            return new SimpleAuthenticationInfo(user, password, email);
        }
    }
    @Override
//    授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        return info;
    }


}
