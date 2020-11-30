package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.mapper.UserLikeBlogMapper;
import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.UserId;
import com.zhang.biyeseji.remeberme.pojo.UserLikeBlog;
import com.zhang.biyeseji.remeberme.pojo.UserLikesBlogId;
import com.zhang.biyeseji.remeberme.service.BlogService;
import com.zhang.biyeseji.remeberme.service.UserLikeBlogServer;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConcernController {
    @Autowired
    BlogService blogService;

    @Autowired
    UserLikeBlogServer userLikeBlogServer;

//    这个是用户点赞的时候触发
    @RequestMapping("userlikeblog")
    @CrossOrigin
    public JSONResult userLikeBlog(@RequestBody  UserLikeBlog userLikeBlog){
        try {
            userLikeBlogServer.insert(userLikeBlog);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败");
        }

    }

    @RequestMapping("deleteuserlikeblog")
    @CrossOrigin
    public JSONResult deleteUserLikeBlog(@RequestBody UserLikeBlog userLikeBlog){
        try {
            userLikeBlogServer.delete(userLikeBlog);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败");
        }
    }

    @RequestMapping("getAllUserLikeBlog")
    @CrossOrigin
    public JSONResult getAllUserLikeBlog(@RequestBody UserId userId){
        try {
            List<UserLikeBlog> userLikeBlogs= userLikeBlogServer.selectUserLikesBlogByUserId(userId.getUserid());
            return JSONResult.ok(userLikeBlogs);
        }catch (Exception e){
            return JSONResult.errorMsg("获取喜欢的博客id失败");
        }

    }

//    获取用户喜欢的博客内容还有用户的信息还有相关的标签
    @RequestMapping("getuserlikesandcontent")
    @CrossOrigin
    public JSONResult getUserLikesAndContent(@RequestBody UserLikesBlogId userLikesBlogId){

        try {
            List<Blog> blogList=blogService.selectBlogByIds(userLikesBlogId);
            return JSONResult.ok(blogList);
        }catch (Exception e){
            return JSONResult.errorMsg("获取喜欢的博客id失败");
        }
    }
}

