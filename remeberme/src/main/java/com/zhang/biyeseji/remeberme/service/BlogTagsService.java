package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.BlogtagsMapper;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.pojo.BlogtagsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  BlogTagsService {

    public List<Blogtags> selectTagsAll();
}
