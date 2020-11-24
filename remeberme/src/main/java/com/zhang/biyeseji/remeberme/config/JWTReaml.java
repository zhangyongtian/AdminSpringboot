package com.zhang.biyeseji.remeberme.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhang.biyeseji.remeberme.MyException.TokenException;
import com.zhang.biyeseji.remeberme.util.JWTService;
import com.zhang.biyeseji.remeberme.util.JWTServiceImp;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

public class JWTReaml extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String token= (String) principalCollection.getPrimaryPrincipal();
        JWTService jwtService=new JWTServiceImp();
        DecodedJWT decodedJWT=jwtService.fromTokenGetInfo(token,"rememberyou");
        String useremail=decodedJWT.getClaim("useremail").asString();
        String userid=decodedJWT.getClaim("userid").asString();
        String username=decodedJWT.getClaim("username").asString();
        String roles=decodedJWT.getClaim("roles").asString();
        String[] role=roles.split(",");
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token= (String) authenticationToken.getPrincipal();
        JWTService jwtService=new JWTServiceImp();
        try {
            DecodedJWT decodedJWT=jwtService.fromTokenGetInfo(token,"rememberyou");
        }catch (Exception e){
            throw new TokenException("token有错误");
        }
        char[] a=new char[]{'a'};
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(token,a,this.getName());
        return simpleAuthenticationInfo;
    }
}
