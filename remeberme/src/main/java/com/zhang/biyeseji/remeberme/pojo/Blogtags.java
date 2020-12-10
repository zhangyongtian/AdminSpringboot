package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;

public class Blogtags  implements Serializable {
    private Integer tagid;

    private String tagname;

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}