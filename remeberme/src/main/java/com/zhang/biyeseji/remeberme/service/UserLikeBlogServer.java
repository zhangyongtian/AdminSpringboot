package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.UserLikeBlog;

import java.util.List;

public interface UserLikeBlogServer {
    void insert(UserLikeBlog userLikeBlog);

    void delete(UserLikeBlog userLikeBlog);

    List<UserLikeBlog> selectUserLikesBlogByUserId(Integer userid);
}
