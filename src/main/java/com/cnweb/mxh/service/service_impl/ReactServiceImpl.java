package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.React;
import com.cnweb.mxh.repository.ReactRepository;
import com.cnweb.mxh.repository.impl.ReactRepositoryImpl;
import com.cnweb.mxh.service.ReactService;

import java.util.List;

public class ReactServiceImpl implements ReactService {
    private ReactRepository reactRepository = new ReactRepositoryImpl();

    @Override
    public React insert(React react) {
        int id = reactRepository.insert(react);
        return reactRepository.findById(id);
    }

    @Override
    public React update(React react) {
        reactRepository.update(react);
        return reactRepository.findById(react.getId());
    }

    @Override
    public React findById(int id) {
        React react = reactRepository.findById(id);
        return react;
    }

    @Override
    public List<React> findAll() {
        return reactRepository.findAll();
    }
}
