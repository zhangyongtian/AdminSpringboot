package com.zhang.biyeseji.remeberme.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhang.biyeseji.remeberme.MyException.TokenException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JWTServiceImp implements JWTService{


    @Override
    public String setInfoToGetToken(Map<String, String> map, String sign) {
        JWTCreator.Builder builder= JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        ;
        return builder.sign(Algorithm.HMAC256(sign));
    }

    @Override
    public boolean testToken(String token,String sign) {
        try {
            JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
        }catch (Exception e){
            throw new TokenException("token失效");
        }
        return false;
    }

    @Override
    public DecodedJWT fromTokenGetInfo(String token, String sign) {

        return JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
    }


}
