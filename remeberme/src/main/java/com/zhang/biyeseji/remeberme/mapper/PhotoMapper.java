package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Photo;

import java.util.List;

public interface PhotoMapper {
    void savephoto(String photosurl);

    List<Photo> selectPagePhoto();

    void deletePhotoById(Integer id);

    Photo getPhotoById(Integer id);

    void updatePhotoById(Photo photo);
}
