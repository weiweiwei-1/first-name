package Informal.mybatis.Realms;

import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
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
        String username=(String)authenticationToken.getPrincipal();
        User user=userService.selectByName(username);
        if(user==null){
            throw new UnknownAccountException("当前用户不存在");
        }
        String address=user.getAddress();
        return new SimpleAuthenticationInfo(user,address,username);
    }
    @Override
//    授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        return info;
    }


}
