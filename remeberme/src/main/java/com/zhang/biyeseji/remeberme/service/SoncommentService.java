package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Soncomment;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndSonComment;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;

public interface SoncommentService {
    List<UseryonghuAndSonComment> selectAllParnetSonCommentByPid(Integer parentid);

    void saveSonComment(Soncomment soncomment);

    PageResult selectPageSoncommentByUseId(PageRequestHasId pageRequestHasId);

    void deleteSonCommentById(Integer id);
}
