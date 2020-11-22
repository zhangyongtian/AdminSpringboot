package com.zhang.biyeseji.remeberme;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhang.biyeseji.remeberme.util.JWTService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    JWTService jwtService;
    @org.junit.Test
    public void nihao(){
        Map<String,String> map=new HashMap<>();
        map.put("name","张永田");
        String token=jwtService.setInfoToGetToken(map,"nihao");
        System.out.println(token);
        DecodedJWT decodedJWT=jwtService.fromTokenGetInfo(token,"nihao");
        System.out.println(decodedJWT.getClaim("name").asString());
    }
}
