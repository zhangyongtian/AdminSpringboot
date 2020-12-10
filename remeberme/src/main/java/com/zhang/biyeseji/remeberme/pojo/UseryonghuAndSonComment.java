package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UseryonghuAndSonComment  implements Serializable {
    private Useryonghu useryonghu;
    private Soncomment soncomment;

    public Useryonghu getUseryonghu() {
        return useryonghu;
    }

    public void setUseryonghu(Useryonghu useryonghu) {
        this.useryonghu = useryonghu;
    }

    public Soncomment getSoncomment() {
        return soncomment;
    }

    public void setSoncomment(Soncomment soncomment) {
        this.soncomment = soncomment;
    }
}
