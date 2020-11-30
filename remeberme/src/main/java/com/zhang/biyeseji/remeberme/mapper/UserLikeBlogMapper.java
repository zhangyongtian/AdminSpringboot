package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.UserLikeBlog;

import java.util.List;

public interface UserLikeBlogMapper {
    void insert(UserLikeBlog userLikeBlog);

    void delete(UserLikeBlog userLikeBlog);

    List<UserLikeBlog> selectUserLikesBlogByUserId(Integer userid);
}
