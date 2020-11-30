package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.UserAndXinxinMapper;
import com.zhang.biyeseji.remeberme.pojo.UserAndXinxin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserAndXinxinServerImp implements UserAndXinxinServer {
    @Autowired
    UserAndXinxinMapper userAndXinxinMapper;
    @Override
    public void insert(UserAndXinxin userAndXinxin) {
        userAndXinxinMapper.insert(userAndXinxin);
    }

    @Override
    public void delete(UserAndXinxin userAndXinxin) {
        userAndXinxinMapper.delete(userAndXinxin);
    }

    @Override
    public List<Integer> selectUserXinXinIdByUserId(Integer userid) {

        return userAndXinxinMapper.selectUserXinXinIdByUserId(userid);
    }
}
