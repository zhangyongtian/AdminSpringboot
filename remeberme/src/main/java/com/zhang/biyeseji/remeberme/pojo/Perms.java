package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class Perms  implements Serializable {
    private Integer permsid;

    private String permsname;

    public Integer getPermsid() {
        return permsid;
    }

    public void setPermsid(Integer permsid) {
        this.permsid = permsid;
    }

    public String getPermsname() {
        return permsname;
    }

    public void setPermsname(String permsname) {
        this.permsname = permsname == null ? null : permsname.trim();
    }
}