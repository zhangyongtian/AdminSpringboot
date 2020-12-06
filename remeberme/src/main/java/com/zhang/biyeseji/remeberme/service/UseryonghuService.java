package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;

public interface UseryonghuService {
    List<Useryonghu> selectUseryonghusByIds(List<Integer> xinxinids);

    Useryonghu selectUseryonghuById(Integer id);

    PageResult getRecommendUser(PageRequest pageRequest);
}
