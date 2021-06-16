package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.Post;

import java.util.List;

public interface PostRepository extends BaseRepository<Post>{
    Integer insert(Post post);
    void update(Post post);
    Post findById(int id);
    List<Post> findAll();
}
