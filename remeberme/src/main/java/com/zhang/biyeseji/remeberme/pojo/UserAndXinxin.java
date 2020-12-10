package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UserAndXinxin  implements Serializable {
    private Integer id;
    private Integer userid;
    private Integer xinxinid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getXinxinid() {
        return xinxinid;
    }

    public void setXinxinid(Integer xinxinid) {
        this.xinxinid = xinxinid;
    }

}
