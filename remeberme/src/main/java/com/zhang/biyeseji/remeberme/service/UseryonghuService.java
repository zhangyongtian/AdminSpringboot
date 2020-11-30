package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UseryonghuService {
    List<Useryonghu> selectUseryonghusByIds(List<Integer> xinxinids);
}
