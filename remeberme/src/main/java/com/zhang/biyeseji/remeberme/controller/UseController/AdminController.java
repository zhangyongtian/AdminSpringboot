package com.zhang.biyeseji.remeberme.controller.UseController;

import com.zhang.biyeseji.remeberme.pojo.*;
import com.zhang.biyeseji.remeberme.service.*;
import com.zhang.biyeseji.remeberme.util.JSONResult;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    ParnetcommentService parnetcommentService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;
    @Autowired
    UseryonghuService useryonghuService;

    @Autowired
    RoleService roleService;

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

    @RequestMapping("userAdminPage")
    @CrossOrigin
    public JSONResult deleteBlogById(@RequestBody PageRequest pageRequest) {
        try {
            PageResult pageResult=userService.selectAllUserAndRole(pageRequest);
            return JSONResult.ok(pageResult);
        } catch (Exception e) {
            return JSONResult.errorMsg("删除失败");
        }
    }


    @RequestMapping("getUserById")
    @CrossOrigin
    public JSONResult getUserById(@RequestBody Useryonghu useryonghu) {
        try {
            Useryonghu useryonghu1=useryonghuService.selectUseryonghuAndRoleById(useryonghu.getId());
            return JSONResult.ok(useryonghu1);
        } catch (Exception e) {
            return JSONResult.errorMsg("删除失败");
        }
    }


    @RequestMapping("deleteUserById")
    @CrossOrigin
    public JSONResult deleteUserById(@RequestBody Useryonghu useryonghu) {
        try {
            useryonghuService.deleteUseryonghuById(useryonghu.getId());
            return JSONResult.ok("删除成功");
        } catch (Exception e) {
            return JSONResult.errorMsg("删除失败");
        }
    }


    @RequestMapping("getAllRole")
    @CrossOrigin
    public JSONResult getAllRole() {
        try {
            List<Role> roleList=roleService.getAllRoles();
            return JSONResult.ok(roleList);
        } catch (Exception e) {
            return JSONResult.errorMsg("获取角色失败");
        }
    }


    @RequestMapping("updateUserRoles")
    @CrossOrigin
    public JSONResult updateUserRoles(@RequestBody Useryonghu useryonghu) {
        try {
            useryonghuService.updataUseryonghuRoles(useryonghu);
            return JSONResult.ok("更改用户的角色成功");
        } catch (Exception e) {
            return JSONResult.errorMsg("更改用户的角色失败");
        }
    }
}
