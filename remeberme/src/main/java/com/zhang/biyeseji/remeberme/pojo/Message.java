package com.zhang.biyeseji.remeberme.pojo;

import java.util.Date;

public class Message {
    private Integer id;

    private String message;

    private Date createtime;

    private Date updatetime;

    private Integer userid;
    private Useryonghu useryonghu;

    public Useryonghu getUseryonghu() {
        return useryonghu;
    }

    public void setUseryonghu(Useryonghu useryonghu) {
        this.useryonghu = useryonghu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}