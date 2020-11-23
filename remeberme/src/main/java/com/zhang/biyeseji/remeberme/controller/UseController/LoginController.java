package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.UserRegister;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.Verification;
import com.zhang.biyeseji.remeberme.service.UserService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.VerificationUtil;
import com.zhang.biyeseji.remeberme.util.mail.IMailService;
import org.apache.catalina.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    IMailService iMailService;

    @Autowired
    VerificationUtil verificationUtil;

    @Autowired
    UserService userService;

    @Value("${salt}")
    String salt;

    @Value("${hashcount}")
    private Integer hashcount;


    @Value("${defaultuserimg}")
    private String defaultuserimg;

    @RequestMapping("/login")
    public String login(){
        return "开始喽";
    }

//    下面是通过邮箱获取验证码的代码
    @RequestMapping(value = "/getVerificationToEmail")
    @CrossOrigin
    public JSONResult getVerificationToEmail(@RequestBody Verification verification){
        //如果是同一个邮箱就只能有一个账号
        String toEmail=verification.getEmail();
        Useryonghu useryonghu1=userService.selectUseryonghuByEmail(toEmail);
        if(null!=useryonghu1){
            return JSONResult.errorMsg("这个邮箱已经注册过账号了");
        }

        String verifica=verificationUtil.getRandRomVerification();
        System.out.println(verifica);
        try {
            stringRedisTemplate.opsForValue().set(toEmail, verifica, 60, TimeUnit.SECONDS);
            iMailService.sendHtmlMail(toEmail,"RememberMe的验证邮件",verifica);
            return JSONResult.ok();
        } catch (MessagingException e) {
            return JSONResult.errorMsg("您输入的邮箱有错误没有办法发送");
        }
    }

    //下面是处理用户注册
    @RequestMapping("/userrigister")
    @CrossOrigin
    public JSONResult userRigister(@RequestBody UserRegister userRegister){

        //这里就是注册过的不能够在注册了

        //这里的代码是新用户注册
        String targetVerification=stringRedisTemplate.opsForValue().get(userRegister.getUseremail());
        String userVerification=userRegister.getVerification();
        if(targetVerification.equals(userVerification)){
            //这里就是保存用户
            Useryonghu useryonghu=new Useryonghu();
            useryonghu.setCommentcount(0);
            useryonghu.setCreatetime(new Date());
            useryonghu.setSalt(salt);
            useryonghu.setUpdatetime(new Date());
            useryonghu.setUseremail(userRegister.getUseremail());
            useryonghu.setUserid(Integer.valueOf(verificationUtil.getRandRomVerification()));
            useryonghu.setUserimage(defaultuserimg);
            useryonghu.setUserlevel(0);
            useryonghu.setUsername(userRegister.getUsername());
            Md5Hash md5Hash=new Md5Hash(userRegister.getUserpassword(),salt,hashcount);
            String password=md5Hash.toHex();
            useryonghu.setUserpassword(password);
            userService.insertUseryonghu(useryonghu);
            return  JSONResult.ok("注册成功");
        }else{
            return JSONResult.errorMsg("用户的验证码过期了");
        }
    }
}
