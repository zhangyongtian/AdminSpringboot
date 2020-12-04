package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.Message;
import com.zhang.biyeseji.remeberme.service.MessageService;
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
public class MessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping("savemessage")
    @CrossOrigin
    public JSONResult  saveMessage(@RequestBody Message message){
        try{
            messageService.saveMessage(message);
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存信息失败");
        }

    }


    @RequestMapping("selectMessagePage")
    @CrossOrigin
    public JSONResult  selectMessagePage(@RequestBody PageRequestHasId pageRequest){
        try{
            PageResult pageResult=messageService.selectPageByPageRequest(pageRequest);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("保存信息失败");
        }

    }

    @RequestMapping("deletemessageById")
    @CrossOrigin
    public JSONResult  deletemessageById(@RequestBody Message message){
        try{
            messageService.deleteMessageById(message.getId());
            return JSONResult.ok();
        }catch (Exception e){
            return JSONResult.errorMsg("保存信息失败");
        }

    }


    @RequestMapping("selectMessageanduserPage")
    @CrossOrigin
    public JSONResult  selectMessageAndUserPage(@RequestBody PageRequest pageRequest){
        try{
            PageResult pageResult=messageService.selectMessageAndUserPage(pageRequest);
            return JSONResult.ok(pageResult);
        }catch (Exception e){
            return JSONResult.errorMsg("获取信息失败");
        }

    }
}
