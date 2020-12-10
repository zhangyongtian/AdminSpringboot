package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UseryonghuToken  implements Serializable {
    private Useryonghu useryonghu;
    private String token;

    public Useryonghu getUseryonghu() {
        return useryonghu;
    }

    public void setUseryonghu(Useryonghu useryonghu) {
        this.useryonghu = useryonghu;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UseryonghuToken{" +
                "useryonghu=" + useryonghu +
                ", token='" + token + '\'' +
                '}';
    }
}
