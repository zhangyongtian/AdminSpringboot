package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.BlogContent;
import com.zhang.biyeseji.remeberme.pojo.Blogclassfiy;
import com.zhang.biyeseji.remeberme.service.BlogClassfiyService;
import com.zhang.biyeseji.remeberme.service.BlogService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
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
}
