package com.zhang.biyeseji.remeberme.config;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    @Value("${hashcount}")
    private Integer hashcount;
    //shiro的过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        JWTaccessControlFilter jwTaccessControlFilter=new JWTaccessControlFilter();

        filters.put("jwtfilter",jwTaccessControlFilter);
        //将自定义过滤器加入到shiro 过滤其中
        shiroFilterFactoryBean.setFilters(filters);

        // 完全无状态认证  noSessionCreation 不保留每次会话的session
//        因此每次请求都会进行授权和认证,（这里要设置过滤的路径才可以使用到shiro的过滤器）
        HashMap<String, String> map = new HashMap<>();
//        map.put("/rememberme/userSinIn","anon");
//        map.put("/rememberme/getVerificationToEmail","anon");
//        map.put("/rememberme/userrigister","anon");
//        map.put("/rememberme/getupdateverify","anon");
//        map.put("/rememberme/updatepassword","anon");
        map.put("/**","noSessionCreation,jwtfilter");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/rememberme/userSinIn");
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    @Bean
    public Realm realm(){
        JWTReaml jwtReaml=new JWTReaml();
        return jwtReaml;
    }
}
