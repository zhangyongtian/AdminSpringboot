package com.zhang.biyeseji.remeberme.config;

import com.zhang.biyeseji.remeberme.util.VerificationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfig {
    @Bean
    public VerificationUtil verificationUtil(){
        VerificationUtil verificationUtil=VerificationUtil.getInstance();
        return verificationUtil;
    }
}
