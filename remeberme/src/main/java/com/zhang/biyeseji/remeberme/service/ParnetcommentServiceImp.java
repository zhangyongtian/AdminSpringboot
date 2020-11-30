package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.ParnetcommentMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.ParnetcommentExample;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ParnetcommentServiceImp implements ParnetcommentService {
    @Autowired
    UseryonghuMapper useryonghuMapper;

    @Autowired
    ParnetcommentMapper parnetcommentMapper;

    @Override
    public void saveParnetcomment(Parnetcomment parnetcomment) {
        parnetcomment.setCreatetime(new Date());
        parnetcomment.setUpdatetime(new Date());
        parnetcomment.setLikes(0);
        parnetcomment.setParnetcommentid(0);
        parnetcomment.setZangcount(0);
        parnetcommentMapper.insert(parnetcomment);
    }

    @Override
    public List<UseryonghuAndComment> selectAllParnetCommentByBlogid(Integer blogId) {
//        先用blog的id查出所有的一级评论然后用评论的userid查评论的用户
        ParnetcommentExample parnetcommentExample=new ParnetcommentExample();
        ParnetcommentExample.Criteria criteria = parnetcommentExample.createCriteria();
        criteria.andBlogidEqualTo(blogId);
        List<Parnetcomment> parnetcomments=parnetcommentMapper.selectByExample(parnetcommentExample);

        //定义返回的结果
        List<UseryonghuAndComment> useryonghuAndComments=new ArrayList<>();
        parnetcomments.forEach(parnetcomment -> {
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(parnetcomment.getUserid());
            UseryonghuAndComment useryonghuAndComment=new UseryonghuAndComment();
            useryonghuAndComment.setUseryonghu(useryonghu);
            useryonghuAndComment.setParnetcomment(parnetcomment);
            useryonghuAndComments.add(useryonghuAndComment);
        });
        return useryonghuAndComments;
    }
}
