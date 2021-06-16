package com.cnweb.mxh.service;

import java.util.List;

public interface BaseService <T>{
    public T insert(T t);

    public T update(T t);

    public T findById(int id);

    public List<T> findAll();
}
