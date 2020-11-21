package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.UserAndRole;
import org.apache.ibatis.annotations.Mapper;

public interface UserAndRoleMapper {
    public void insertUserAndRole(UserAndRole userAndRole);
}
