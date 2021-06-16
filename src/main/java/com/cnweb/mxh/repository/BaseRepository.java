package com.cnweb.mxh.repository;
import com.cnweb.mxh.mapper.RowMapper;

import java.util.List;

public interface BaseRepository<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    int insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
