package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.BlogAndTag;

import java.util.List;

public interface BlogAndTagMapper {
    public void saveBlogAndTag(BlogAndTag blogAndTag);

    void saveBlogAndTagList(List<BlogAndTag> blogAndTagList);

    void deleteByBlogId(Integer id);
}
