package com.zhang.biyeseji.remeberme.pojo;

import javax.xml.crypto.Data;
import java.util.List;

public class BlogContent {
    private Integer userid;
    private String title;
    private String headimg;
    private List<Integer> classfiy;
    private List<Integer> tag;
    private Data createTime;
    private Boolean isfabu;
    private String introduce;
    private String content;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public List<Integer> getClassfiy() {
        return classfiy;
    }

    public void setClassfiy(List<Integer> classfiy) {
        this.classfiy = classfiy;
    }

    public List<Integer> getTag() {
        return tag;
    }

    public void setTag(List<Integer> tag) {
        this.tag = tag;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }



    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsfabu() {
        return isfabu;
    }

    public void setIsfabu(Boolean isfabu) {
        this.isfabu = isfabu;
    }
}
