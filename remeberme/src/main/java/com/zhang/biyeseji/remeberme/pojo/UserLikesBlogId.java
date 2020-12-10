package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;
import java.util.List;

public class UserLikesBlogId  implements Serializable {
    private List<Integer> userlikesblogid;

    public List<Integer> getUserlikesblogid() {
        return userlikesblogid;
    }

    public void setUserlikesblogid(List<Integer> userlikesblogid) {
        this.userlikesblogid = userlikesblogid;
    }
}
