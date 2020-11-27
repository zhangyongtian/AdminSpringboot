package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.*;
import com.zhang.biyeseji.remeberme.pojo.*;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;
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

    @Autowired
    UseryonghuMapper useryonghuMapper;

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

    @Override
    public PageResult getPageResultBlog(PageRequest pageRequest) {
        int startPage=pageRequest.getPageNum();
        int pageNum=pageRequest.getPageSize();
        Page page=PageHelper.startPage(startPage,pageNum);
        List<Blog> bloglist = blogMapper.getPageResultBlog();
        bloglist.forEach(blog -> {
            Integer userid=blog.getUserid();
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);

        });
        PageResult pageResult=new PageResult();
        pageResult.setContent(bloglist);
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        return pageResult;
    }


}
