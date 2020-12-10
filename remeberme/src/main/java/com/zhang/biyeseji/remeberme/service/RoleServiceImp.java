package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.RoleMapper;
import com.zhang.biyeseji.remeberme.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList=roleMapper.selectAllRole();
        return roleList;
    }
}
