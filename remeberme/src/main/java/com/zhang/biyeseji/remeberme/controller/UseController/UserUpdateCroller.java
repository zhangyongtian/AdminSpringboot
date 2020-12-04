package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.UserRegister;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.Verification;
import com.zhang.biyeseji.remeberme.service.UserService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.VerificationUtil;
import com.zhang.biyeseji.remeberme.util.mail.IMailService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Version;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.concurrent.TimeUnit;

@RestController
public class UserUpdateCroller {

    @Value("${mailupdatepasswordverfi}")
    private String mailupdatepasswordverfi;
    @Autowired
    IMailService iMailService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    VerificationUtil verificationUtil;

    @Autowired
    UserService userService;

    @Value("${salt}")
    private String salt;
    @Value("${hashcount}")
    private Integer hashcount;
    @RequestMapping("/getupdateverify")
    @CrossOrigin
    public JSONResult getUpdateVerify(@RequestBody  Useryonghu useryonghu1){
        //首先判断用户是否有账号，没有账号就不能够修改密码
        String userEmail=useryonghu1.getUseremail();
        Useryonghu useryonghu=userService.selectUseryonghuByEmail(userEmail);
        if(null==useryonghu){
            return JSONResult.errorMsg("用户有账号了");
        }
        String userEmailRediskey=userEmail+mailupdatepasswordverfi;
        String userEmailValue= verificationUtil.getRandRomVerification();
        stringRedisTemplate.opsForValue().set(userEmailRediskey,userEmailValue,60, TimeUnit.SECONDS);
        try {
            iMailService.sendHtmlMail(userEmail,"Remermber 修改密码的邮件",userEmailValue);
        } catch (MessagingException e) {
            e.printStackTrace();
            return JSONResult.errorMsg("邮箱写错了哦");
        }
        return JSONResult.ok();
    }

    @RequestMapping("updatepassword")
    @CrossOrigin
    public JSONResult updatepassword(@RequestBody  UserRegister userRegister){
        String userRedisKey=userRegister.getUseremail()+mailupdatepasswordverfi;
        String target=stringRedisTemplate.opsForValue().get(userRedisKey);
        if(target==null){
            return JSONResult.errorMsg("验证码过期了");
        }
        if(target.equals(userRegister.getVerification())){
            //这里获取验证码成功
            String password=new Md5Hash(userRegister.getUserpassword(),salt,hashcount).toHex();
            userService.updateUser(userRegister.getUseremail(),password);
            return JSONResult.ok();
        }else{
            return JSONResult.errorMsg("验证码有问题,错误或者过期了");
        }
    }

//    这里是根据id修改用户
@RequestMapping("userrequest")
@CrossOrigin
public JSONResult userrequest(@RequestBody  Useryonghu useryonghu){
        try{
            userService.updateUserById(useryonghu);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("修改用户失败");
        }

}

}
