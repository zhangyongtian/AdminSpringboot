package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.BlogclassfiyMapper;
import com.zhang.biyeseji.remeberme.pojo.Blogclassfiy;
import com.zhang.biyeseji.remeberme.pojo.BlogclassfiyExample;
import com.zhang.biyeseji.remeberme.service.BlogClassfiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BlogClassfiyServiceImp implements BlogClassfiyService {
    @Autowired
    BlogclassfiyMapper blogclassfiyMapper;
    @Override
    public List<Blogclassfiy> selectClassfiyAll() {
        return blogclassfiyMapper.selectClassfiyAll();
    }

    @Override
    public void saveBlogClassfiy(Blogclassfiy blogclassfiy) {
        blogclassfiyMapper.insert(blogclassfiy);
    }

    @Override
    public void deleteBlogClassfiyById(Blogclassfiy blogclassfiy) {
        BlogclassfiyExample blogclassfiyExample=new BlogclassfiyExample();
        BlogclassfiyExample.Criteria criteria = blogclassfiyExample.createCriteria();
        criteria.andClassfiyidEqualTo(blogclassfiy.getClassfiyid());
        blogclassfiyMapper.deleteByExample(blogclassfiyExample);
    }
}
