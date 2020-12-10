package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class BlogAndTag implements Serializable {
    private Integer id;
    private Integer blogid;
    private Integer tagid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}
