package com.jk.xinx.config;

import com.jk.xinx.pojo.user.UserBean;
import com.jk.xinx.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        Integer userId = (Integer) SecurityUtils.getSubject().getPrincipal();
//
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();



        HashSet<String> roleSet = userService.findRoleSet(userId);
//
//        //添加资源授权字符串   测试时写死   真正运行时需要从数据库中查出字符串
        info.setRoles(roleSet);
        HashSet<String> perms = new HashSet<>();
        perms.add("user:add");

        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        UserBean userBean = userService.selectByAccount(token.getUsername());

        if (userBean == null){
            return null;
        }


        return new SimpleAuthenticationInfo(userBean.getCid(),userBean.getPassword(),"");
    }

}
