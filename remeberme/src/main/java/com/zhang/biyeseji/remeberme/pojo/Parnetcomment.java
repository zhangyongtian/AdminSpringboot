package com.zhang.biyeseji.remeberme.pojo;

import java.util.Date;

public class Parnetcomment {
    private Integer id;

    private Integer parnetcommentid;

    private String comment;

    private Date createtime;

    private Integer zangcount;

    private Integer likes;

    private Integer blogid;

    private Integer userid;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParnetcommentid() {
        return parnetcommentid;
    }

    public void setParnetcommentid(Integer parnetcommentid) {
        this.parnetcommentid = parnetcommentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getZangcount() {
        return zangcount;
    }

    public void setZangcount(Integer zangcount) {
        this.zangcount = zangcount;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}