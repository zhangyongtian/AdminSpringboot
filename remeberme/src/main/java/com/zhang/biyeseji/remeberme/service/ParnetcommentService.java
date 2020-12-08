package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndComment;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;


public interface ParnetcommentService {
    void saveParnetcomment(Parnetcomment parnetcomment);

    List<UseryonghuAndComment> selectAllParnetCommentByBlogid(Integer blogId);

    PageResult selectParnetCommentByUserId(PageRequestHasId pageRequestHasId);

    void deleteParnetCommentById(Integer id);

    PageResult selectPageForAllCommend(PageRequest pageRequest);
}
