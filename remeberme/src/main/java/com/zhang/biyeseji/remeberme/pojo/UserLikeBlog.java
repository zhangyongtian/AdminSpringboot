package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UserLikeBlog implements Serializable {
    private Integer id;
    private Integer userid;
    private Integer blogid;

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

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }
}
