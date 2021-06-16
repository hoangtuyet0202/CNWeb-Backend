package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Comment;
import com.cnweb.mxh.repository.CommentRepository;
import com.cnweb.mxh.repository.impl.CommentRepositoryImpl;
import com.cnweb.mxh.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public Comment insert(Comment comment) {
        int id = commentRepository.insert(comment);
        return commentRepository.findById(id);
    }

    @Override
    public Comment update(Comment comment) {
        commentRepository.update(comment);
        return commentRepository.findById(comment.getId());
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
