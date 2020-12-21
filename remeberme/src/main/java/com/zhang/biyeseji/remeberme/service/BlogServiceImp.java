package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.*;
import com.zhang.biyeseji.remeberme.pojo.*;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageRequestHasId;
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

    @Autowired
    EsClientService esClientService;


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
        //保存博客的时候对于用户的等级加一
        Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(blogContent.getUserid());
        int userlevel=useryonghu.getUserlevel()+1;
        UseryonghuExample example=new UseryonghuExample();
        UseryonghuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(blogContent.getUserid());
        useryonghuMapper.updateByExample(useryonghu,example);

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

//        插入数据以后保存一份到es

        esClientService.saveToEs(blog);

    }

    @Override
    public PageResult getPageResultBlog(PageRequest pageRequest) {
        //        判断分类的id还有tagid


        int startPage=pageRequest.getPageNum();
        int pageNum=pageRequest.getPageSize();
        Page page=PageHelper.startPage(startPage,pageNum);
        BlogExample blogExample=new BlogExample();
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

    @Override
    public List<Blog> selectBlogByIds(UserLikesBlogId userLikesBlogId) {
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdIn(userLikesBlogId.getUserlikesblogid());
        List<Blog> blogList=blogMapper.selectByExample(blogExample);
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);
        });
        return blogList;
    }

    @Override
    public PageResult getBlogsByUserIdPageRequest(UserBlogPageRequest userBlogPageRequest) {
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andUseridEqualTo(userBlogPageRequest.getUserid());
        int pageNum=userBlogPageRequest.getPageNum();
        int pageSize=userBlogPageRequest.getPageSize();
        Page page=PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList=blogMapper.selectByExample(blogExample);
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);

        });
        PageResult pageResult=new PageResult();
        pageResult.setContent(blogList);
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        return pageResult;
    }

    @Override
    public PageResult selectBlogByUserId(PageRequestHasId pageRequestHasId) {
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andUseridEqualTo(pageRequestHasId.getUserid());
        Page page=PageHelper.startPage(pageRequestHasId.getPageNum(),pageRequestHasId.getPageSize());
        List<Blog> blogList=blogMapper.selectByExample(blogExample);
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
//            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
//            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);

        });
        PageResult pageResult=new PageResult();
        pageResult.setContent(blogList);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        pageResult.setPageSize(pageRequestHasId.getPageSize());
        pageResult.setPageNum(pageRequestHasId.getPageNum());
        return pageResult;
    }

    @Override
    public void deleteBlogById(Integer id) {

        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Blog selectBlogById(Integer id) {
        Blog blog=blogMapper.selectByPrimaryKey(id);
        List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
        blog.setBlogclassfiys(classfiys);
        List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
        blog.setBlogtags(blogtags);
        return blog;
    }

    @Override
    public void updateBlog(BlogContent blogContent) {
        //首先更新blog
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdEqualTo(blogContent.getId());
        Blog blog=new Blog();
        blog.setIsfabu(blogContent.getIsfabu());
        blog.setTitle(blogContent.getTitle());
        blog.setHeadpic(blogContent.getHeadimg());
        blog.setIntroduce(blogContent.getIntroduce());
        blog.setContent(blogContent.getContent());
        blog.setUpdatetime(new Date());
        blogMapper.updateByExampleSelective(blog,blogExample);
        //下面是更新tag还有classfiy是中间的表先删除后插入
        blogAndTagMapper.deleteByBlogId(blogContent.getId());
        List<Integer> tags=blogContent.getTag();
        List<BlogAndTag> blogAndTagList=new ArrayList<>();
        tags.forEach((tag)->{
            BlogAndTag blogAndTag=new BlogAndTag();
            blogAndTag.setBlogid(blogContent.getId());
            blogAndTag.setTagid(tag);
            blogAndTagList.add(blogAndTag);
        });
        blogAndTagMapper.saveBlogAndTagList(blogAndTagList);

//        先删除classfiy
        blogAndClassfiyMapper.deleteByBlogid(blogContent.getId());
        List<Integer> classfiys=blogContent.getClassfiy();
        List<BlogAndClassfiy> classfiys1=new ArrayList<>();
        classfiys.forEach(classfiy->{
            BlogAndClassfiy blogAndClassfiy=new BlogAndClassfiy();
            blogAndClassfiy.setBlogid(blogContent.getId());
            blogAndClassfiy.setBlogclassfiy(classfiy);
            classfiys1.add(blogAndClassfiy);
        });


        blogAndClassfiyMapper.saveBlogAndClassfiyList(classfiys1);
    }

    @Override
    public PageResult selectBlogPage(PageRequest pageRequest) {
        Page page=PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Blog> blogList=blogMapper.selectAllBlog();
        PageResult pageResult=new PageResult();
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setPageNum(pageRequest.getPageNum());
//        下面就是根据所有的文章查用户
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
            blog.setUseryonghu(useryonghu);
        });
        pageResult.setContent(blogList);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        return pageResult;
    }

    @Override
    public Blog getBlogByIdAndUser(Integer id) {
        Blog blog=blogMapper.selectByPrimaryKey(id);
        Integer userid=blog.getUserid();
        Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
        blog.setUseryonghu(useryonghu);
        List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
        blog.setBlogclassfiys(classfiys);
        List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
        blog.setBlogtags(blogtags);
        return blog;
    }

    @Override
    public PageResult getBlogPageByClassfiy(PageRequest nowclassfiy) {
//        根据classfiy查询所有的blog
        PageResult pageResult=new PageResult();
        Page page=PageHelper.startPage(nowclassfiy.getPageNum(),nowclassfiy.getPageSize());
        List<Blog> blogList=blogAndClassfiyMapper.selectBlogByClassFiy(nowclassfiy.getNowclassfiy());
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
//            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
//            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(blog.getUserid());
            useryonghu.setUserpassword(null);
            blog.setUseryonghu(useryonghu);

        });
        pageResult.setContent(blogList);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        pageResult.setPageSize(nowclassfiy.getPageSize());
        pageResult.setPageNum(nowclassfiy.getPageNum());
        return pageResult;
    }

    @Override
    public PageResult getBlogPageBytag(PageRequest nowclassfiy) {
        PageResult pageResult=new PageResult();
        Page page=PageHelper.startPage(nowclassfiy.getPageNum(),nowclassfiy.getPageSize());
        List<Blog> blogList=blogAndClassfiyMapper.selectBlogByTag(nowclassfiy.getNowtag());
        blogList.forEach(blog -> {
            Integer userid=blog.getUserid();
//            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(userid);
//            blog.setUseryonghu(useryonghu);
            List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
            blog.setBlogclassfiys(classfiys);
            List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
            blog.setBlogtags(blogtags);
            Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(blog.getUserid());
            useryonghu.setUserpassword(null);
            blog.setUseryonghu(useryonghu);

        });
        pageResult.setContent(blogList);
        pageResult.setTotalPages(page.getPages());
        pageResult.setTotalSize(page.getTotal());
        pageResult.setPageSize(nowclassfiy.getPageSize());
        pageResult.setPageNum(nowclassfiy.getPageNum());
        return pageResult;

    }


}
