package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.BlogtagsMapper;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.pojo.BlogtagsExample;
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

    @Override
    public void insertBlogTags(Blogtags blogtags) {
        blogtagsMapper.insert(blogtags);
    }

    @Override
    public void deletetagById(Blogtags blogtags) {
        BlogtagsExample blogtagsExample=new BlogtagsExample();
        BlogtagsExample.Criteria criteria = blogtagsExample.createCriteria();
        criteria.andTagidEqualTo(blogtags.getTagid());
        blogtagsMapper.deleteByExample(blogtagsExample);
    }
}
