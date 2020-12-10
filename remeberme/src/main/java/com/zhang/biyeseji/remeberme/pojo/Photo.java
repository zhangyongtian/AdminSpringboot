package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class Photo  implements Serializable {
    private Integer id;
    private String imgurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
