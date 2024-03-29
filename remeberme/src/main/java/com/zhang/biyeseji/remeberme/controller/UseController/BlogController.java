package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.mapper.SoncommentMapper;
import com.zhang.biyeseji.remeberme.pojo.*;
import com.zhang.biyeseji.remeberme.service.BlogClassfiyService;
import com.zhang.biyeseji.remeberme.service.BlogService;
import com.zhang.biyeseji.remeberme.service.ParnetcommentService;
import com.zhang.biyeseji.remeberme.service.SoncommentService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.apache.commons.codec.language.bm.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    SoncommentService soncommentService;

    @Autowired
    ParnetcommentService parnetcommentService;

    @Autowired
    BlogClassfiyService blogClassfiyService;

    @Autowired
    BlogService blogService;

    @RequestMapping("getAllBlogClassfiy")
    @CrossOrigin
    public JSONResult getAllBlogClassfiy(){
        List<Blogclassfiy> blogclassfiyList=blogClassfiyService.selectClassfiyAll();
        return JSONResult.ok(blogclassfiyList);
    }

//    这里是保存bolg的时候使用的

    @RequestMapping("saveBlog")
    @CrossOrigin
    public JSONResult saveBlog(@RequestBody  BlogContent blogContent){
        if(null!=blogContent){
            blogService.saveBlog(blogContent);
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("保存blog错误");
    }

//    接收当前的页数还有每一页的个数进行分页

    @RequestMapping("getBlogPageHelper")
    @CrossOrigin
    public PageResult getBlogPageHelper(@RequestBody PageRequest pageRequest){
        PageResult pageResult=blogService.getPageResultBlog(pageRequest);
        return pageResult;
    }

    //下面是对于博客的评论保存
    @RequestMapping("savecomment")
    @CrossOrigin
    public JSONResult saveComment(@RequestBody Parnetcomment parnetcomment){
        try {
            parnetcommentService.saveParnetcomment(parnetcomment);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存评论错误");
        }
    }
    //得到博客的所有的父评论
    @RequestMapping("showParentComment")
    @CrossOrigin
    public JSONResult showParentComment(@RequestBody  Parnetcomment parnetcomment){
        //这里返回一个评论还有发表评论用户的一个对象数组
        Integer blogId=parnetcomment.getBlogid();
        try {
            List<UseryonghuAndComment> useryonghuAndComments= parnetcommentService.selectAllParnetCommentByBlogid(blogId);
            return JSONResult.ok(useryonghuAndComments);
        }catch (Exception e){
            return  JSONResult.errorMsg("获取评论失败");
        }

    }

//    保存子评论
    @RequestMapping("savesoncomment")
    @CrossOrigin
    public JSONResult savesonComment(@RequestBody  Soncomment soncomment){
        try {
            soncommentService.saveSonComment(soncomment);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("子评论保存错误");
        }

    }

//    下面是查询子评论
    @RequestMapping("showsoncomment")
    @CrossOrigin
    public JSONResult showSonComment(@RequestBody Soncomment soncomment){
        try {
            List<UseryonghuAndSonComment> useryonghuAndSonComments=soncommentService.selectAllParnetSonCommentByPid(soncomment.getParentid());
            return JSONResult.ok(useryonghuAndSonComments);
        }catch (Exception e){
            return JSONResult.errorMsg("显示子评论错误");
        }

    }
}
