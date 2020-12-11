package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.service.BlogTagsService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogTagsController {
    @Autowired
    BlogTagsService blogTagsService;

    @RequestMapping("getAllBlogTags")
    @CrossOrigin
    public JSONResult getAllBlogTags(){
        List<Blogtags> blogtagsList=blogTagsService.selectTagsAll();
        return JSONResult.ok(blogtagsList);
    }

    @RequiresRoles(value = {"superadmin","admin"},logical= Logical.OR)
    @RequestMapping("savetag")
    @CrossOrigin
    public JSONResult savetag(@RequestBody Blogtags blogtags){
        try {
            blogTagsService.insertBlogTags(blogtags);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存标签失败");
        }

    }

    @RequiresRoles(value = {"superadmin","admin"},logical= Logical.OR)
    @RequestMapping("deletetagById")
    @CrossOrigin
    public JSONResult deletetagById(@RequestBody Blogtags blogtags){
        try {
            blogTagsService.deletetagById(blogtags);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存标签失败");
        }

    }
}
