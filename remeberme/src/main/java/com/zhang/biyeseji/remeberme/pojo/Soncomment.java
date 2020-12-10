package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;
import java.util.Date;

public class Soncomment  implements Serializable {
    private Integer id;

    private String comment;

    private Date createtime;

    private Date updatetime;

    private Integer parentid;

    private Integer zangcount;

    private Integer likes;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}