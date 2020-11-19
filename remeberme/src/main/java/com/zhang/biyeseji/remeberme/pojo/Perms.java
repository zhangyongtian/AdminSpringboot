package com.zhang.biyeseji.remeberme.pojo;

public class Perms {
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