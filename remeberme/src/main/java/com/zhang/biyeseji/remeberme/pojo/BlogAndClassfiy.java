package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class BlogAndClassfiy implements Serializable {
    private Integer id;
    private Integer blogid;
    private Integer blogclassfiy;

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

    public Integer getBlogclassfiy() {
        return blogclassfiy;
    }

    public void setBlogclassfiy(Integer blogclassfiy) {
        this.blogclassfiy = blogclassfiy;
    }
}
