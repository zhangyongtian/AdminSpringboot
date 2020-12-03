package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.SoncommentMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Soncomment;
import com.zhang.biyeseji.remeberme.pojo.SoncommentExample;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndSonComment;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class SoncommentServiceImp implements SoncommentService {
    @Autowired
    SoncommentMapper soncommentMapper;

    @Autowired
    UseryonghuMapper useryonghuMapper;
    @Override
    public List<UseryonghuAndSonComment> selectAllParnetSonCommentByPid(Integer parentid) {
        SoncommentExample soncommentExample=new SoncommentExample();
        SoncommentExample.Criteria criteria = soncommentExample.createCriteria();
        criteria.andParentidEqualTo(parentid);

//        定义最后要保存的对象
        List<UseryonghuAndSonComment> useryonghuAndSonComments=new ArrayList<>();
        List<Soncomment> soncomments=soncommentMapper.selectByExample(soncommentExample);
        soncomments.forEach(soncomment -> {
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(soncomment.getUserid());
            UseryonghuAndSonComment useryonghuAndSonComment=new UseryonghuAndSonComment();
            useryonghuAndSonComment.setSoncomment(soncomment);
            useryonghuAndSonComment.setUseryonghu(useryonghu);
            useryonghuAndSonComments.add(useryonghuAndSonComment);
        });
        return useryonghuAndSonComments;
    }

    @Override
    public void saveSonComment(Soncomment soncomment) {
        soncomment.setCreatetime(new Date());
        soncomment.setUpdatetime(new Date());
        soncomment.setZangcount(0);
        soncomment.setLikes(0);
        soncommentMapper.insert(soncomment);
    }

    @Override
    public PageResult selectPageSoncommentByUseId(PageRequestHasId pageRequestHasId) {
        SoncommentExample soncommentExample=new SoncommentExample();
        SoncommentExample.Criteria criteria = soncommentExample.createCriteria();
        criteria.andUseridEqualTo(pageRequestHasId.getUserid());
        Page page= PageHelper.startPage(pageRequestHasId.getPageNum(),pageRequestHasId.getPageSize());
        List<Soncomment> soncomments=soncommentMapper.selectByExample(soncommentExample);
        PageResult pageResult=new PageResult();
        pageResult.setPageNum(pageRequestHasId.getPageNum());
        pageResult.setPageSize(pageRequestHasId.getPageSize());
        pageResult.setTotalSize(page.getTotal());
        pageResult.setTotalPages(page.getPages());
        pageResult.setContent(soncomments);
        return pageResult;
    }

    @Override
    public void deleteSonCommentById(Integer id) {
        SoncommentExample soncommentExample=new SoncommentExample();
        SoncommentExample.Criteria criteria = soncommentExample.createCriteria();
        criteria.andIdEqualTo(id);
        soncommentMapper.deleteByExample(soncommentExample);
    }
}
