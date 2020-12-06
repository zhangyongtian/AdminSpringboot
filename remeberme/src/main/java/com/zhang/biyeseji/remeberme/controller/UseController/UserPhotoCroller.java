package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.Photo;
import com.zhang.biyeseji.remeberme.service.PhotoService;
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
public class UserPhotoCroller {
    @Autowired
    PhotoService photoService;

    //这里是查询图片的地方
    @RequestMapping("selectPagePhoto")
    @CrossOrigin
    public JSONResult selectPagePhoto(@RequestBody PageRequest pageRequest){
        try {
            PageResult pageResult= photoService.selectPagePhoto(pageRequest);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("查找图片失败");
        }
    }

    @RequestMapping("selectAllPhoto")
    @CrossOrigin
    public JSONResult selectAllPhoto(){
        try {
            List<Photo> photoList=photoService.selectAllPhoto();
            return JSONResult.ok(photoList);
        }catch (Exception e){
            return JSONResult.errorMsg("查找图片失败");
        }
    }

}
