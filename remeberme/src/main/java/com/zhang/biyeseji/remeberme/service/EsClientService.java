package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;
import java.util.Map;

//定义这个接口的目的是在保存blog的时候宝保存一份到es，然后查询的时候查出一个list
public interface EsClientService {
    public  void saveToEs(Blog blog);

    //定义个参数是定义要查询的字段用map
    public List<Map<String,Object>> getBlogFromEsByPageRequest(Map<String,String> fieldMap,Integer pageNum,Integer pageSize,String indexs);

    public void deleteBlogFormEs(String blogid);
}
