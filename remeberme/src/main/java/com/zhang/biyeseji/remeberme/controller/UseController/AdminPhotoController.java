package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.Photo;
import com.zhang.biyeseji.remeberme.pojo.Photourl;
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
@RequestMapping("admin")
public class AdminPhotoController {

    @Autowired
    PhotoService photoService;
    //这里就是保存照片墙图片的地方
    @RequestMapping("savephoto")
    @CrossOrigin
    public JSONResult savePhotos(@RequestBody Photourl photourl){
        try {
            photoService.savaPhoto(photourl.getPhotosurl());
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存图片失败");
        }
    }



    //这里是查询图片的地方
    @RequestMapping("selectPagePhoto")
    @CrossOrigin
    public JSONResult selectPagePhoto(@RequestBody  PageRequest pageRequest){
        try {
            PageResult pageResult= photoService.selectPagePhoto(pageRequest);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("查找图片失败");
        }
    }

    //这里是查询图片的地方
    @RequestMapping("deletePhotoById")
    @CrossOrigin
    public JSONResult deletePhotoById(@RequestBody Photo photo){
        try {
           photoService.deletePhotoById(photo.getId());
            return JSONResult.ok("删除图片成功");
        }catch (Exception e){
            return JSONResult.errorMsg("删除图片失败");
        }
    }


    //获得的照片用id
    @RequestMapping("getPhotoById")
    @CrossOrigin
    public JSONResult dgetPhotoById(@RequestBody Photo photo){
        try {
            Photo photo1= photoService.getPhotoById(photo.getId());
            return JSONResult.ok(photo1);
        }catch (Exception e){
            return JSONResult.errorMsg("删除图片失败");
        }
    }


    //根据id修改图片
    @RequestMapping("updatePhotoById")
    @CrossOrigin
    public JSONResult updatePhotoById(@RequestBody Photo photo){
        try {
            photoService.updatePhotoById(photo);
            return JSONResult.ok("修改图片成功");
        }catch (Exception e){
            return JSONResult.errorMsg("修改图片成功失败");
        }
    }
}
