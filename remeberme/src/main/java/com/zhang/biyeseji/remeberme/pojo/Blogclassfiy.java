package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class Blogclassfiy implements Serializable {
    private Integer classfiyid;

    private String classfiyname;

    public Integer getClassfiyid() {
        return classfiyid;
    }

    public void setClassfiyid(Integer classfiyid) {
        this.classfiyid = classfiyid;
    }

    public String getClassfiyname() {
        return classfiyname;
    }

    public void setClassfiyname(String classfiyname) {
        this.classfiyname = classfiyname == null ? null : classfiyname.trim();
    }
}