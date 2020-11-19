package com.zhang.biyeseji.remeberme.pojo;

import java.util.Date;

public class Blog {
    private Integer id;

    private Integer blogid;

    private Integer zangcount;

    private Integer likes;

    private String headpic;

    private String title;

    private String introduce;

    private Integer userid;

    private Date createtime;

    private Date updatetime;

    private String content;

    private Boolean isfabu;

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

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsfabu() {
        return isfabu;
    }

    public void setIsfabu(Boolean isfabu) {
        this.isfabu = isfabu;
    }
}