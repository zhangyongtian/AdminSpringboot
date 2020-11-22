package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Useryonghu;

public interface UserService {
    public void insertUseryonghu(Useryonghu useryonghu);

    Useryonghu selectUseryonghuByName(String username);

    Useryonghu selectUseryonghuByEmail(String useremail);
}
