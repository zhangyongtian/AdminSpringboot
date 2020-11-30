package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Soncomment;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndSonComment;

import java.util.List;

public interface SoncommentService {
    List<UseryonghuAndSonComment> selectAllParnetSonCommentByPid(Integer parentid);

    void saveSonComment(Soncomment soncomment);
}
