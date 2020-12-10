package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class Userorgin  implements Serializable {
    private Integer userorginid;

    private Integer userorgincount;

    private String useroriginname;

    public Integer getUserorginid() {
        return userorginid;
    }

    public void setUserorginid(Integer userorginid) {
        this.userorginid = userorginid;
    }

    public Integer getUserorgincount() {
        return userorgincount;
    }

    public void setUserorgincount(Integer userorgincount) {
        this.userorgincount = userorgincount;
    }

    public String getUseroriginname() {
        return useroriginname;
    }

    public void setUseroriginname(String useroriginname) {
        this.useroriginname = useroriginname == null ? null : useroriginname.trim();
    }
}