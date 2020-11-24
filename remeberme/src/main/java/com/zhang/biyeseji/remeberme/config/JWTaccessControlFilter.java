package com.zhang.biyeseji.remeberme.config;

import com.alibaba.druid.util.StringUtils;
import com.zhang.biyeseji.remeberme.util.JWTService;
import com.zhang.biyeseji.remeberme.util.JWTServiceImp;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JWTaccessControlFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        //当主体对象不为空且已经获得认证时允许访问
        System.out.println("开始验证的时候"+subject.isAuthenticated());
        if (null != subject && subject.isAuthenticated()){
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String jwtToken= httpServletRequest.getHeader("token");
        //客户端没有携带token
        if (StringUtils.isEmpty(jwtToken)) {
            System.out.println("请求头没有token");
            return true;
        }
        System.out.println("拒接访问");
        JWTService jwtService=new JWTServiceImp();
        Subject subject = SecurityUtils.getSubject();
        //进行认证
        JWTauthenticationToken jwTauthenticationToken=new JWTauthenticationToken(jwtToken);
        subject.login(jwTauthenticationToken);
        System.out.println("认证的结果是"+subject.isAuthenticated());
        return true;
    }
}
