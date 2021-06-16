package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Image;
import com.cnweb.mxh.repository.ImageRepository;
import com.cnweb.mxh.repository.impl.ImageRepositoryImpl;
import com.cnweb.mxh.service.ImageService;

import java.util.List;

public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository = new ImageRepositoryImpl();

    @Override
    public Image insert(Image image) {
        int id = imageRepository.insert(image);
        return imageRepository.findById(id);
    }

    @Override
    public Image update(Image image) {
        imageRepository.update(image);
        return imageRepository.findById(image.getId());
    }

    @Override
    public Image findById(int id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
