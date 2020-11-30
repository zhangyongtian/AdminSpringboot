package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.UserAndXinxin;

import java.util.List;

public interface UserAndXinxinServer {
    void insert(UserAndXinxin userAndXinxin);

    void delete(UserAndXinxin userAndXinxin);

    List<Integer> selectUserXinXinIdByUserId(Integer userid);
}
