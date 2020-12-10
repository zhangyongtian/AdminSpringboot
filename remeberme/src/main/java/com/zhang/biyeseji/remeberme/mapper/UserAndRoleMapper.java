package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Role;
import com.zhang.biyeseji.remeberme.pojo.UserAndRole;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserAndRoleMapper {
    public void insertUserAndRole(UserAndRole userAndRole);

    void deleteUseryonghuRoleByUserId(Integer id);

    void insertRoles(Useryonghu useryonghu);
}
