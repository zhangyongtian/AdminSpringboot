package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuAndComment;
import com.zhang.biyeseji.remeberme.service.BlogService;
import com.zhang.biyeseji.remeberme.service.ParnetcommentService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    ParnetcommentService parnetcommentService;

    @Autowired
    BlogService blogService;

    @RequestMapping("getAllcomment")
    @CrossOrigin
    public JSONResult getAllcomment(@RequestBody PageRequest pageRequest){
        try {
            PageResult pageResult=parnetcommentService.selectPageForAllCommend(pageRequest);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("获取失败");
        }
    }

    @RequestMapping("deletecommentById")
    @CrossOrigin
    public JSONResult deletecommentById(@RequestBody Parnetcomment parnetcomment){
        try {
            parnetcommentService.deleteParnetCommentById(parnetcomment.getId());
            return JSONResult.ok("删除成功");
        }catch (Exception e){
            return JSONResult.errorMsg("删除失败");
        }
    }

    //    下面是查出所有的的blog然后查出他们对应的用户
    @RequestMapping("getAticleAdminPage")
    @CrossOrigin
    public JSONResult getAticleAdminPage(@RequestBody PageRequest pageRequest) {
        try {
            PageResult pageResult=blogService.selectBlogPage(pageRequest);
            return JSONResult.ok(pageResult);
        } catch (Exception e) {
            return JSONResult.errorMsg("删除失败");
        }
    }

    //下面是根据blogid删除blog

    @RequestMapping("deleteBlogById")
    @CrossOrigin
    public JSONResult deleteBlogById(@RequestBody Blog blog) {
        try {
            blogService.deleteBlogById(blog.getId());
            return JSONResult.ok("删除成功");
        } catch (Exception e) {
            return JSONResult.errorMsg("删除失败");
        }
    }
}
