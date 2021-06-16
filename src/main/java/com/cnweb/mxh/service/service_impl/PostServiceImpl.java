package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Post;
import com.cnweb.mxh.repository.PostRepository;
import com.cnweb.mxh.repository.impl.PostRepositoryImpl;
import com.cnweb.mxh.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post insert(Post post) {
        int id = postRepository.insert(post);
        return postRepository.findById(id);
    }

    @Override
    public Post update(Post post) {
        postRepository.update(post);
        return postRepository.findById(post.getId());
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
