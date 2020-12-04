package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.MessageMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Message;
import com.zhang.biyeseji.remeberme.pojo.MessageExample;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.util.PageRequest;
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
public class MessageServiceImp implements  MessageService{
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UseryonghuMapper useryonghuMapper;
    @Override
    public void saveMessage(Message message) {
        message.setCreatetime(new Date());
        message.setUpdatetime(new Date());
        messageMapper.insert(message);
    }

    @Override
    public PageResult selectPageByPageRequest(PageRequestHasId pageRequest) {
        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andUseridEqualTo(pageRequest.getUserid());
        Page page= PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        PageResult pageResult=new PageResult();
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalSize(page.getTotal());
        pageResult.setTotalPages(page.getPages());
        pageResult.setContent(messageList);
        pageResult.setPageNum(pageRequest.getPageNum());
        return pageResult;
    }

    @Override
    public void deleteMessageById(Integer id) {
        messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageResult selectMessageAndUserPage(PageRequest pageRequest) {
        Page page=PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Message> messageList=messageMapper.selectAllMessage();
        messageList.forEach(message -> {
            Integer userid=message.getUserid();
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
            message.setUseryonghu(useryonghu);
        });

        PageResult pageResult=new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setContent(messageList);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        return pageResult;
    }


}
