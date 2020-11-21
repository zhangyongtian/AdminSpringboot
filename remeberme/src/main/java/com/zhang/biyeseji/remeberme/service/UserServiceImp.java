package com.zhang.biyeseji.remeberme.service;
import com.zhang.biyeseji.remeberme.mapper.UserAndRoleMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.UserAndRole;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UseryonghuMapper useryonghuMapper;

    @Autowired
    UserAndRoleMapper userAndRoleMapper;
    //这个就是保存用户并且初始化用户为普通用户
    @Override
    public void insertUseryonghu(Useryonghu useryonghu) {
        //保存用户的基本信息
        useryonghuMapper.insert(useryonghu);
        UserAndRole userAndRole=new UserAndRole();
        userAndRole.setUserid(useryonghu.getId());
        userAndRole.setRoleid(1);
        userAndRoleMapper.insertUserAndRole(userAndRole);
    }
}
