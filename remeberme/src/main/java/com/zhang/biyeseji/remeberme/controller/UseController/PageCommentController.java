package com.zhang.biyeseji.remeberme.controller.UseController;

import com.github.pagehelper.Page;
import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.Soncomment;
import com.zhang.biyeseji.remeberme.service.ParnetcommentService;
import com.zhang.biyeseji.remeberme.service.SoncommentService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageCommentController {
    @Autowired
    ParnetcommentService parnetcommentService;

    @Autowired
    SoncommentService soncommentService;
    @RequestMapping("parenetpagecomment")
    @CrossOrigin
    public JSONResult pageComment(@RequestBody  PageRequestHasId pageRequestHasId){
//        根据用户的id获取所有的comment
//        这个是父评论的获取的地方
        try {
            PageResult pageResult=parnetcommentService.selectParnetCommentByUserId(pageRequestHasId);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("获取评论的内容失败");
        }

    }
//    根据评论的id删除父评论
    @RequestMapping("deleteparentcomment")
    @CrossOrigin
    public JSONResult deleteparentcomment(@RequestBody Parnetcomment parnetcomment){
//        根据用户的id获取所有的comment
//        这个是父评论的获取的地方
        try {
            parnetcommentService.deleteParnetCommentById(parnetcomment.getId());
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("获取评论的内容失败");
        }

    }


    //    根据评论的id删除父评论
    @RequestMapping("soncommentRequest")
    @CrossOrigin
    public JSONResult sonCommentRequest(@RequestBody  PageRequestHasId pageRequestHasId){
//        根据用户的id获取所有的comment
//        这个是父评论的获取的地方
        try {
            PageResult pageResult=soncommentService.selectPageSoncommentByUseId(pageRequestHasId);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("获取评论的内容失败");
        }

    }

    //    根据评论的id删除子评论
    @RequestMapping("deletesoncomment")
    @CrossOrigin
    public JSONResult deleteSonComment(@RequestBody Soncomment soncomment){
//        根据用户的id获取所有的comment
//        这个是父评论的获取的地方
        try {
            soncommentService.deleteSonCommentById(soncomment.getId());
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("获取评论的内容失败");
        }

    }
}
