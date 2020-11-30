package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.BlogMapper;
import com.zhang.biyeseji.remeberme.mapper.UserLikeBlogMapper;
import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.UserLikeBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserLikeBlogServerImp implements UserLikeBlogServer {
    @Autowired
    UserLikeBlogMapper userLikeBlogMapper;

    @Autowired
    BlogMapper blogMapper;
    @Override
    public void insert(UserLikeBlog userLikeBlog) {
//        对应的博客的赞要增加
        Blog blog=blogMapper.selectByPrimaryKey(userLikeBlog.getBlogid());
        Integer thumbsup=blog.getZangcount()+1;
        blog.setZangcount(thumbsup);
        blogMapper.updateByPrimaryKey(blog);
        userLikeBlogMapper.insert(userLikeBlog);
    }

    @Override
    public void delete(UserLikeBlog userLikeBlog) {
        //        对应的博客的赞要减少
        Blog blog=blogMapper.selectByPrimaryKey(userLikeBlog.getBlogid());
        Integer thumbsup=blog.getZangcount()-1;
        blog.setZangcount(thumbsup);
        blogMapper.updateByPrimaryKey(blog);
        userLikeBlogMapper.delete(userLikeBlog);
    }

    @Override
    public List<UserLikeBlog> selectUserLikesBlogByUserId(Integer userid) {
        return userLikeBlogMapper.selectUserLikesBlogByUserId(userid);
    }

}
