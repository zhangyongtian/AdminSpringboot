package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.mapper.*;
import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.BlogAndClassfiy;
import com.zhang.biyeseji.remeberme.pojo.BlogAndTag;
import com.zhang.biyeseji.remeberme.pojo.BlogContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogServiceImp implements BlogService{
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogAndClassfiyMapper blogAndClassfiyMapper;

    @Autowired
    BlogAndTagMapper blogAndTagMapper;

    @Override
    public void saveBlog(BlogContent blogContent) {

//        对于blog的保存
        Blog blog=new Blog();
        blog.setBlogid(blogContent.getUserid());
        blog.setContent(blogContent.getContent());
        blog.setHeadpic(blogContent.getHeadimg());
        blog.setTitle(blogContent.getTitle());
        blog.setIntroduce(blogContent.getIntroduce());
        blog.setUserid(blogContent.getUserid());
        blog.setCreatetime(new Date());
        blog.setUpdatetime(new Date());
        blog.setZangcount(0);
        blog.setLikes(0);
        blog.setIsfabu(blogContent.getIsfabu());
        blogMapper.insert(blog);

        //保存blog的所属的分类还有标签
        List<BlogAndClassfiy> blogAndClassfiyList=new ArrayList<>();
        blogContent.getClassfiy().forEach(classfiy->{
            BlogAndClassfiy blogAndClassfiy=new BlogAndClassfiy();
            blogAndClassfiy.setBlogid(blog.getId());
            blogAndClassfiy.setBlogclassfiy(classfiy);
            blogAndClassfiyList.add(blogAndClassfiy);
        });

        blogAndClassfiyMapper.saveBlogAndClassfiyList(blogAndClassfiyList);

//        保存blog对应的标签
        List<BlogAndTag> blogAndTagList=new ArrayList<>();
        blogContent.getTag().forEach(tag->{
            BlogAndTag blogAndTag=new BlogAndTag();
            blogAndTag.setBlogid(blog.getId());
            blogAndTag.setTagid(tag);
            blogAndTagList.add(blogAndTag);
        });

        blogAndTagMapper.saveBlogAndTagList(blogAndTagList);

    }
}
