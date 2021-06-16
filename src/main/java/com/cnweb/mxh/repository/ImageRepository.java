package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.Image;

import java.util.List;

public interface ImageRepository extends BaseRepository<Image>{
    Integer insert(Image image);
    void update(Image image);
    Image findById(int id);
    List<Image> findAll();
}
