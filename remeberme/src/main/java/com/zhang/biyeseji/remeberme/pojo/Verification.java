package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;
public class Verification implements Serializable {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Verification(String email) {
        this.email = email;
    }
    public Verification(){

    }

    @Override
    public String toString() {
        return "Verification{" +
                "email='" + email + '\'' +
                '}';
    }
}
