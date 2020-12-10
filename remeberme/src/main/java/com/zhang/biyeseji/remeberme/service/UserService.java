package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;

public interface UserService {
    public void insertUseryonghu(Useryonghu useryonghu);

    Useryonghu selectUseryonghuByName(String username);

    Useryonghu selectUseryonghuByEmail(String useremail);

    void updateUser(String userEmail, String userpassword);

    void updateUserById(Useryonghu useryonghu);

    PageResult selectAllUserAndRole(PageRequest pageRequest);
}
