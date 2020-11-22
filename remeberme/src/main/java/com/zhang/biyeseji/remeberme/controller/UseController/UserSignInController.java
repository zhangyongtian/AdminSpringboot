package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuToken;
import com.zhang.biyeseji.remeberme.service.UserService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import org.apache.catalina.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignInController {

    @Value("${hashcount}")
    private Integer hashcount;
    @Autowired
    UserService userService;

    @RequestMapping("/userSinIn")
    @CrossOrigin
    public JSONResult userSginIn(@RequestBody Useryonghu useryonghu){
        //根据前端发过来的type来判断是用户名字登录还是用户用邮箱登录
        Useryonghu useryonghu1 = null;
        if(useryonghu.getSiginType()==1){
//            需要查寻下数据库
             useryonghu1=userService.selectUseryonghuByName(useryonghu.getUsername());
//            这里就是根据用户名用来处理登录
            String password=new Md5Hash(useryonghu.getUserpassword(),useryonghu1.getSalt(),hashcount).toHex();
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(useryonghu.getUsername(),useryonghu.getUserpassword());
            Subject subject= SecurityUtils.getSubject();
            //这里进行shiro认证
            try{
                subject.login(usernamePasswordToken);
                System.out.println(subject.isAuthenticated());
            }catch (UnknownAccountException e){
                System.out.println("账户美欧");
            }catch (Exception e){
                System.out.println("你好");
                System.out.println(e);
            }
            return JSONResult.ok(useryonghu1);
        }else{
//            这里就是用邮箱登录
            useryonghu1=userService.selectUseryonghuByEmail(useryonghu.getUsername());
            //这里登陆的时候ream会自己去加盐还有进行hash认证
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(useryonghu.getUsername(),useryonghu.getUserpassword());
            Subject subject=SecurityUtils.getSubject();
            try{
                subject.login(usernamePasswordToken);
                System.out.println(subject.isAuthenticated());
            }catch (UnknownAccountException e){
                System.out.println("账户美欧");
            }catch (IncorrectCredentialsException e){
                System.out.println("你好");
                System.out.println(e);
            }
//            UseryonghuToken useryonghuToken=new UseryonghuToken();
//            useryonghuToken.setUseryonghu(useryonghu1);
//            //下面是登录成功以后给用户发送token
//            System.out.println(useryonghu1);


            return JSONResult.ok(useryonghu1);
        }
    }
}
