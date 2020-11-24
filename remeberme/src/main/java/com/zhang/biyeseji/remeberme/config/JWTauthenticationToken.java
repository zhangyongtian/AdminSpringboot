package com.zhang.biyeseji.remeberme.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

public class JWTauthenticationToken extends UsernamePasswordToken {
    private String jwttoken;
    public JWTauthenticationToken(String token) {
        this.jwttoken=token;
    }

    @Override
    public String getUsername() {
        return this.jwttoken;
    }

    @Override
    public char[] getPassword() {
        return new char[]{'a'};
    }

    @Override
    public Object getPrincipal() {
        return this.jwttoken;
    }

    @Override
    public Object getCredentials() {
        return new char[]{'a'};
    }
}
