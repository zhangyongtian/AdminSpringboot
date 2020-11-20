package com.zhang.biyeseji.remeberme.util;

public class VerificationUtil {
    private static VerificationUtil verificationUtil;
    private VerificationUtil(){

    }
    public static VerificationUtil getInstance(){
        if(null==verificationUtil){
            synchronized (VerificationUtil.class){
                if(null==verificationUtil){
                    verificationUtil=new VerificationUtil();
                }
            }
        }
        return verificationUtil;
    }
    public static String getRandRomVerification(){
        String target=String.valueOf(Math.random()*1000000);
        int pointIndex=target.indexOf(".");
        String result=target.substring(0,pointIndex);
        return result;
    }
}
