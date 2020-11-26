package com.zhang.biyeseji.remeberme.controller.UseController;

import com.alibaba.fastjson.JSON;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.service.BlogTagsService;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
