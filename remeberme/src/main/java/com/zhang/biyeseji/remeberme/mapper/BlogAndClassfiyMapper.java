package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.BlogAndClassfiy;

import java.util.List;

public interface BlogAndClassfiyMapper {
    public void saveBlogAndClassfiy(BlogAndClassfiy blogAndClassfiy);

    void saveBlogAndClassfiyList(List<BlogAndClassfiy> blogAndClassfiyList);

    void deleteByBlogid(Integer id);

    List<Blog> selectBlogByClassFiy(Integer nowclassfiy);

    List<Blog> selectBlogByTag(Integer nowtag);
}
