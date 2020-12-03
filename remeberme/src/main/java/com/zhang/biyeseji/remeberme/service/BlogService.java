package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.BlogContent;
import com.zhang.biyeseji.remeberme.pojo.UserBlogPageRequest;
import com.zhang.biyeseji.remeberme.pojo.UserLikesBlogId;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;

public interface BlogService {
    public void saveBlog(BlogContent blogContent);

    PageResult getPageResultBlog(PageRequest pageRequest);

    List<Blog> selectBlogByIds(UserLikesBlogId userLikesBlogId);

    PageResult getBlogsByUserIdPageRequest(UserBlogPageRequest userBlogPageRequest);

    PageResult selectBlogByUserId(PageRequestHasId pageRequestHasId);

    void deleteBlogById(Integer id);

    Blog selectBlogById(Integer id);

    void updateBlog(BlogContent blogContent);
}
