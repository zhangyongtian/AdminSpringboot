package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuExample;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UseryonghuServiceImp implements UseryonghuService {

    @Autowired
    UseryonghuMapper useryonghuMapper;
    @Override
    public List<Useryonghu> selectUseryonghusByIds(List<Integer> xinxinids) {
        UseryonghuExample useryonghuExample=new UseryonghuExample();
        UseryonghuExample.Criteria criteria = useryonghuExample.createCriteria();
        criteria.andIdIn(xinxinids);
        return useryonghuMapper.selectByExample(useryonghuExample);
    }

    @Override
    public Useryonghu selectUseryonghuById(Integer id) {
        return useryonghuMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult getRecommendUser(PageRequest pageRequest) {
        Page page= PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Useryonghu> useryonghus=useryonghuMapper.selectAllUseryonghu();
        PageResult pageResult=new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setContent(useryonghus);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        return pageResult;
    }
}
