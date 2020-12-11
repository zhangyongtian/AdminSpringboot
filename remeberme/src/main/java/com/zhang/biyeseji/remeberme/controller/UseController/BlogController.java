package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.mapper.SoncommentMapper;
import com.zhang.biyeseji.remeberme.pojo.*;
import com.zhang.biyeseji.remeberme.service.*;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    UseryonghuService useryonghuService;

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


    @RequiresRoles(value = {"superadmin","admin"},logical= Logical.OR)
    @RequestMapping("saveclassfiy")
    @CrossOrigin
    public JSONResult saveClassfiy(@RequestBody Blogclassfiy blogclassfiy){
        try {
            blogClassfiyService.saveBlogClassfiy(blogclassfiy);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败");
        }

    }


//这里是管理元才可以了
    @RequiresRoles(value = {"superadmin","admin"},logical= Logical.OR)
    @RequestMapping("deleteclassfiyById")
    @CrossOrigin
    public JSONResult deleteclassfiyById(@RequestBody Blogclassfiy blogclassfiy){
        try {
            blogClassfiyService.deleteBlogClassfiyById(blogclassfiy);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败");
        }

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


    //    下面是查询子评论
    @RequestMapping("getrecommenduser")
    @CrossOrigin
    public JSONResult getrecommenduser(@RequestBody PageRequest pageRequest){
        try {
            PageResult useryonghus=useryonghuService.getRecommendUser(pageRequest);
            return JSONResult.ok(useryonghus);
        }catch (Exception e){
            return JSONResult.errorMsg("获取推荐作者的信息失败");
        }

    }


    //    下面是根据用户的id获取blog
    @RequestMapping("getblogpagebyuserid")
    @CrossOrigin
    public JSONResult getBlogPageByUserId(@RequestBody PageRequestHasId pageRequestHasId){
        try {
            PageResult pageResult=blogService.selectBlogByUserId(pageRequestHasId);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("获取推荐作者的信息失败");
        }

    }

    //这里是删除blog用id

    @RequestMapping("deleteblogById")
    @CrossOrigin
    public JSONResult deleteblogById(@RequestBody Blog blog) {
        try {
            blogService.deleteBlogById(blog.getId());
            return JSONResult.ok();
        } catch (Exception e) {
            return JSONResult.errorMsg("删除blog失败");
        }
    }


    //根据blog的id查询blog

    @RequestMapping("getBlogbyId")
    @CrossOrigin
    public JSONResult getBlogbyId(@RequestBody Blog blog) {
        try {
            Blog blog1=blogService.selectBlogById(blog.getId());
            return JSONResult.ok(blog1);
        } catch (Exception e) {
            return JSONResult.errorMsg("删除blog失败");
        }
    }


    //修改blog

    @RequestMapping("updateblog")
    @CrossOrigin
    public JSONResult updateblog(@RequestBody  BlogContent blogContent) {
        try {
            blogService.updateBlog(blogContent);
            return JSONResult.ok();
        } catch (Exception e) {
            return JSONResult.errorMsg("删除blog失败");
        }
    }

    @RequestMapping("getBlogByIdAndUser")
    @CrossOrigin
    public JSONResult getBlogByIdAndUser(@RequestBody Blog blog) {
        try {
            Blog blog1=blogService.getBlogByIdAndUser(blog.getId());
            return JSONResult.ok(blog1);
        } catch (Exception e) {
            return JSONResult.errorMsg("获取blog失败");
        }
    }
}
