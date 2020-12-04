package com.zhang.biyeseji.remeberme.service;
import com.zhang.biyeseji.remeberme.mapper.UserAndRoleMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.UserAndRole;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuExample;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    @Override
    public Useryonghu selectUseryonghuByName(String username) {
        return useryonghuMapper.selectUseryonghuByname(username);
    }

    @Override
    public Useryonghu selectUseryonghuByEmail(String useremail) {
        return useryonghuMapper.selectUseryonghuByEmail(useremail);
    }

    @Override
    public void updateUser(String userEmail, String userpassword) {
        Useryonghu useryonghu=new Useryonghu();
        useryonghu.setUserpassword(userpassword);
        UseryonghuExample useryonghuExample=new UseryonghuExample();
        UseryonghuExample.Criteria criteria = useryonghuExample.createCriteria();
        criteria.andUseremailEqualTo(userEmail);
        useryonghuMapper.updateByExampleSelective(useryonghu,useryonghuExample);
    }

    @Override
    public void updateUserById(Useryonghu useryonghu) {
        UseryonghuExample useryonghuExample=new UseryonghuExample();
        UseryonghuExample.Criteria criteria = useryonghuExample.createCriteria();
        criteria.andIdEqualTo(useryonghu.getId());
        useryonghuMapper.updateByExampleSelective(useryonghu,useryonghuExample);
    }
}
