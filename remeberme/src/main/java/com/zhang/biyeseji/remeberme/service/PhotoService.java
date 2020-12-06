package com.zhang.biyeseji.remeberme.service;

import com.zhang.biyeseji.remeberme.pojo.Photo;
import com.zhang.biyeseji.remeberme.util.PageRequest;
import com.zhang.biyeseji.remeberme.util.PageResult;

import java.util.List;

public interface PhotoService {
    void savaPhoto(String photosurl);

    PageResult selectPagePhoto(PageRequest pageRequest);

    void deletePhotoById(Integer id);


    Photo getPhotoById(Integer id);

    void updatePhotoById(Photo photo);

    List<Photo> selectAllPhoto();
}
