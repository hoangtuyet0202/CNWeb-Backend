package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.ImageMapper;
import com.cnweb.mxh.model.Image;
import com.cnweb.mxh.repository.ImageRepository;

import java.util.List;

public class ImageRepositoryImpl extends AbstractRepository<Image> implements ImageRepository {
    private String sql;
    @Override
    public Integer insert(Image image) {
        sql = "insert into image(post_id, url, alt) values(?, ? ,?)";
        return insert(sql, image.getPost_id(), image.getUrl(), image.getAlt());
    }

    @Override
    public void update(Image image) {
        sql = "update image set post_id = ?, url = ?, alt = ? where id = ?";
        update(sql, image.getPost_id(), image.getUrl(), image.getAlt(), image.getId());
    }

    @Override
    public Image findById(int id) {
        sql = "select * from image where id = ?";
        List<Image> images = query(sql, new ImageMapper(), id);
        return images.isEmpty() ? null : images.get(0);
    }

    @Override
    public List<Image> findAll() {
        sql = "select * from image";
        return query(sql, new ImageMapper());
    }
}
