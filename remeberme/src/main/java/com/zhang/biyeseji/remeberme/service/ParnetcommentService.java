package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndComment;

import java.util.List;


public interface ParnetcommentService {
    void saveParnetcomment(Parnetcomment parnetcomment);

    List<UseryonghuAndComment> selectAllParnetCommentByBlogid(Integer blogId);
}
