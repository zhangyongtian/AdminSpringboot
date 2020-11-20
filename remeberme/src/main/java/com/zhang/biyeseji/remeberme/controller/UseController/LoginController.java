package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhang.biyeseji.remeberme.pojo.Verification;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class LoginController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/login")
    public String login(){
        return "开始喽";
    }
    @RequestMapping(value = "/getVerificationToEmail")
    @CrossOrigin
    public String getVerificationToEmail(@RequestBody Verification verification){
        System.out.println(verification);
        System.out.println("我过来了");
        return "nihao";
    }
}
