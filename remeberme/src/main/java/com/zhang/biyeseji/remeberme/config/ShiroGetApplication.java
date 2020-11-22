package com.zhang.biyeseji.remeberme.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ShiroGetApplication implements ApplicationContextAware {
    private static ApplicationContext mYapplicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mYapplicationContext=applicationContext;
    }
    public static ApplicationContext getmYapplicationContext(){
        return mYapplicationContext;
    }
}
