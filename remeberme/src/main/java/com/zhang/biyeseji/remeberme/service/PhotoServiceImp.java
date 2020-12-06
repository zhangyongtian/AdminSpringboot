package com.zhang.biyeseji.remeberme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.biyeseji.remeberme.mapper.PhotoMapper;
import com.zhang.biyeseji.remeberme.pojo.Photo;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhotoServiceImp implements PhotoService {
    @Autowired
    PhotoMapper photoMapper;
    @Override
    public void savaPhoto(String photosurl) {
        photoMapper.savephoto(photosurl);
    }

    @Override
    public PageResult selectPagePhoto(PageRequest pageRequest) {
        Page page= PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<Photo> photoList=photoMapper.selectPagePhoto();
        PageResult pageResult=new PageResult();
        pageResult.setTotalSize(page.getTotal());
        pageResult.setTotalPages(page.getPages());
        pageResult.setContent(photoList);
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setPageNum(pageRequest.getPageNum());
        return pageResult;
    }

    @Override
    public void deletePhotoById(Integer id) {
        photoMapper.deletePhotoById(id);
    }

    @Override
    public Photo getPhotoById(Integer id) {

        return photoMapper.getPhotoById(id);
    }

    @Override
    public void updatePhotoById(Photo photo) {
        photoMapper.updatePhotoById(photo);
    }

    @Override
    public List<Photo> selectAllPhoto() {
        return photoMapper.selectPagePhoto();
    }

}
