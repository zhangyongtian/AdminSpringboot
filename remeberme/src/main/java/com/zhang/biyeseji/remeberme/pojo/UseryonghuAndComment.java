package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UseryonghuAndComment  implements Serializable {
    private Useryonghu useryonghu;
    private Parnetcomment parnetcomment;

    public Useryonghu getUseryonghu() {
        return useryonghu;
    }

    public void setUseryonghu(Useryonghu useryonghu) {
        this.useryonghu = useryonghu;
    }

    public Parnetcomment getParnetcomment() {
        return parnetcomment;
    }

    public void setParnetcomment(Parnetcomment parnetcomment) {
        this.parnetcomment = parnetcomment;
    }
}
