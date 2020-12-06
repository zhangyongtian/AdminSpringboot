package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.util.FastDFSClient;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FdfsController {
    @Value("${imgserve}")
    private String imgserve;
    @Autowired
    FastDFSClient fastDFSClient;

    @RequestMapping("uploadFile")
    @CrossOrigin
    public JSONResult uploadFileImg(@RequestParam("img") MultipartFile img){
        String imgurl=null;
        try {
            imgurl=imgserve+fastDFSClient.uploadFile(img);
            return JSONResult.ok(imgurl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONResult.errorMsg("上传错误");
    }

    @RequestMapping("uploadFilemultiple")
    @CrossOrigin
    public JSONResult uploadFilemultiple(@RequestParam("img") MultipartFile[] img){
        String imgurl=null;
        List<String> strings=new ArrayList<>();
        try {
            for(int i=0;i<img.length;i++){
                imgurl=imgserve+fastDFSClient.uploadFile(img[i]);
                strings.add(imgurl);
            }
            return JSONResult.ok(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONResult.errorMsg("上传错误");
    }
}
