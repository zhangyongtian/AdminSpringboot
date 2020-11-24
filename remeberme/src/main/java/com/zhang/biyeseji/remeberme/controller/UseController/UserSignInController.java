package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.zhang.biyeseji.remeberme.pojo.Role;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuToken;
import com.zhang.biyeseji.remeberme.service.UserService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.JWTService;
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

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserSignInController {

    @Value("${mysign}")
    private String mySign;
    @Value("${hashcount}")
    private Integer hashcount;
    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @RequestMapping("/userSinIn")
    @CrossOrigin
    public JSONResult userSginIn(@RequestBody Useryonghu useryonghu){
        //            下面是不同的shiro认证
//            **********************************************
        //这里登陆的时候ream会自己去加盐还有进行hash认证
        //根据前端发过来的type来判断是用户名字登录还是用户用邮箱登录1表示用户名登录
        if(useryonghu.getSiginType()==1){
//          UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(useryonghu.getUsername(),useryonghu.getUserpassword());
//            Subject subject= SecurityUtils.getSubject();
//            //这里进行shiro认证
//            try{
//                subject.login(usernamePasswordToken);
////                这里是用户登录成功
//                System.out.println(subject.isAuthenticated());
//                //这个使用用户的用户名作为token体进行封装成一个token
//
//                Map<String,String> tokenChaimMap=new HashMap<>();
//                tokenChaimMap.put("username",useryonghu.getUsername());
//                String token=jwtService.setInfoToGetToken(tokenChaimMap,mySign);
//                Useryonghu useryonghu1=userService.selectUseryonghuByName(useryonghu.getUsername());
//                clearUseryonghuTactfulInfo(useryonghu1);
//
//                UseryonghuToken useryonghuToken=new UseryonghuToken();
//                useryonghuToken.setUseryonghu(useryonghu1);
//                useryonghuToken.setToken(token);
//                //最后返回得到的登录信息到前端
//                return JSONResult.ok(useryonghuToken);
//            }catch (UnknownAccountException e){
//                System.out.println(e);
//                return JSONResult.errorMsg("没有这个账号");
//            }catch (IncorrectCredentialsException e){
//                System.out.println(e);
//                return JSONResult.errorMsg("用户的密码错误");
//            }
            ////            *****************************************************
////不同的shiro认证的代码到这里结束
            Useryonghu useryonghu1=userService.selectUseryonghuByName(useryonghu.getUsername());
            if(null==useryonghu1){
                return JSONResult.errorMsg("用户名错误");
            }
//            对于找到的用户生成token
            Map<String,String> tokenChaimMap=new HashMap<>();
            tokenChaimMap.put("useremail",useryonghu1.getUseremail());
            tokenChaimMap.put("userid", String.valueOf(useryonghu1.getId()));
            tokenChaimMap.put("username",useryonghu1.getUsername());
            StringBuilder roles=new StringBuilder();
            useryonghu1.getRoles().forEach(role -> {
                roles.append(role.getRolename()+","+role.getRoleid()+",");
            });
            String role=roles.toString();
            tokenChaimMap.put("roles",role);
            String token=jwtService.setInfoToGetToken(tokenChaimMap,mySign);

            UseryonghuToken useryonghuToken=new UseryonghuToken();
            clearUseryonghuTactfulInfo(useryonghu1);
            useryonghuToken.setUseryonghu(useryonghu1);
            useryonghuToken.setToken(token);
            return JSONResult.ok(useryonghuToken);
        }else{
//            下面是不同的shiro认证
//            **********************************************
            //这里登陆的时候ream会自己去加盐还有进行hash认证
//            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(useryonghu.getUsername(),useryonghu.getUserpassword());
//            Subject subject=SecurityUtils.getSubject();
//            try{
//                subject.login(usernamePasswordToken);
//                System.out.println(subject.isAuthenticated());
//                //这里是登录成功以后的处
//                //这个使用用户的用户名作为token体进行封装成一个token
//                Map<String,String> tokenChaimMap=new HashMap<>();
//                tokenChaimMap.put("username",useryonghu.getUsername());
//                String token=jwtService.setInfoToGetToken(tokenChaimMap,mySign);
//
////              由于这里和上面的代码有挺多相同的地方，可以在这里离优化，考虑到代码优化以后效率一样
////                就为了代码清晰度好的标准来来了
//                Useryonghu useryonghu1=userService.selectUseryonghuByEmail(useryonghu.getUsername());
//                clearUseryonghuTactfulInfo(useryonghu1);
//
//                UseryonghuToken useryonghuToken=new UseryonghuToken();
//                useryonghuToken.setUseryonghu(useryonghu1);
//                useryonghuToken.setToken(token);
//                //最后返回得到的登录信息到前端
//                return JSONResult.ok(useryonghuToken);
//            }catch (UnknownAccountException e){
//                System.out.println("账户没有哦");
//            }catch (IncorrectCredentialsException e){
//                System.out.println("无效的密码");
//                System.out.println(e);
//            }
////            *****************************************************
////不同的shiro认证的代码到这里结束

            Useryonghu useryonghu1=userService.selectUseryonghuByEmail(useryonghu.getUsername());
            if(null==useryonghu1){
                return JSONResult.errorMsg("用户邮箱登录错误");
            }
//            对于找到的用户生成token
            Map<String,String> tokenChaimMap=new HashMap<>();
            tokenChaimMap.put("useremail",useryonghu1.getUseremail());
            tokenChaimMap.put("userid", String.valueOf(useryonghu1.getId()));
            tokenChaimMap.put("username",useryonghu1.getUsername());
            StringBuilder roles=new StringBuilder();
            useryonghu1.getRoles().forEach(role -> {
                roles.append(role.getRolename()+" "+role.getRoleid()+",");
            });
            String role=roles.toString();
            tokenChaimMap.put("roles",role);
            String token=jwtService.setInfoToGetToken(tokenChaimMap,mySign);

            UseryonghuToken useryonghuToken=new UseryonghuToken();
            clearUseryonghuTactfulInfo(useryonghu1);
            useryonghuToken.setUseryonghu(useryonghu1);
            useryonghuToken.setToken(token);
            return JSONResult.ok(useryonghuToken);
        }
    }

    //这个方法是用类给返回前端的时候清空用户的一些敏感信息
    public static void clearUseryonghuTactfulInfo(Useryonghu useryonghu){
        useryonghu.setUserpassword(null);
        useryonghu.setUserid(null);
        useryonghu.setSalt(null);
        useryonghu.setId(null);
        for (Role role : useryonghu.getRoles()) {
            role.setRoleid(null);
        }
    }
}
