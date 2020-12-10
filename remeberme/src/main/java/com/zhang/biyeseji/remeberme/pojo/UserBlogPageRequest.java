package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class UserBlogPageRequest  implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
//    这里就是useryonghu的自增id
    private Integer userid;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
