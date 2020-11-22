package com.zhang.biyeseji.remeberme.util;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public interface JWTService {
    public String setInfoToGetToken(Map<String, String> map,String sign);

    public boolean testToken(String token,String sign);

    public DecodedJWT fromTokenGetInfo(String token, String sign);
}
