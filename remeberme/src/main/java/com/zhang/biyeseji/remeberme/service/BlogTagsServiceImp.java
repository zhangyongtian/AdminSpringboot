package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.BlogtagsMapper;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BlogTagsServiceImp implements BlogTagsService {
    @Autowired
    BlogtagsMapper blogtagsMapper;
    @Override
    public List<Blogtags> selectTagsAll() {
        return blogtagsMapper.selectTagsAll();
    }
}
