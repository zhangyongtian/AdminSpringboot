package com.zhang.biyeseji.remeberme.config;

import com.zhang.biyeseji.remeberme.pojo.Role;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.util.ByteUtils;

import java.util.List;

public class MyReaml extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userinfo= (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo=null;
        if(userinfo.length()<10){
//            这里使用的是用户名登陆
            UserService userService=ShiroGetApplication.getmYapplicationContext().getBean(UserService.class);
            Useryonghu useryonghu=userService.selectUseryonghuByName(userinfo);
            List<Role> roles=useryonghu.getRoles();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getRolename());
            });
        }else{
//            这里使用的是用户邮箱登陆
            UserService userService=ShiroGetApplication.getmYapplicationContext().getBean(UserService.class);
            Useryonghu useryonghu=userService.selectUseryonghuByEmail(userinfo);
            List<Role> roles=useryonghu.getRoles();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getRolename());
            });
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        SimpleAuthenticationInfo simpleAuthenticationInfo=null;
        if(username.length()<10){
//            这里使用的使用用户名登陆
            UserService userService=ShiroGetApplication.getmYapplicationContext().getBean(UserService.class);
            Useryonghu useryonghu=userService.selectUseryonghuByName(username);
            if(null!=useryonghu){
                simpleAuthenticationInfo=new SimpleAuthenticationInfo(useryonghu.getUsername(),useryonghu.getUserpassword(), ByteSource.Util.bytes(useryonghu.getSalt()),this.getName());
            }
        }else{
//            这里使用的是邮箱登陆
            UserService userService=ShiroGetApplication.getmYapplicationContext().getBean(UserService.class);
            Useryonghu useryonghu=userService.selectUseryonghuByEmail(username);
            if(null!=useryonghu){
                simpleAuthenticationInfo=new SimpleAuthenticationInfo(useryonghu.getUseremail(),useryonghu.getUserpassword(),ByteSource.Util.bytes(useryonghu.getSalt()),this.getName());
            }
        }
        return simpleAuthenticationInfo;
    }
}
