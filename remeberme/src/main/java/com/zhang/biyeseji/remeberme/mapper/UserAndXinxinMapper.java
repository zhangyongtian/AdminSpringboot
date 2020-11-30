package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.UserAndXinxin;

import java.util.List;

public interface UserAndXinxinMapper {
    public void insert(UserAndXinxin userAndXinxin);

    void delete(UserAndXinxin userAndXinxin);

    List<Integer> selectUserXinXinIdByUserId(Integer userid);
}
