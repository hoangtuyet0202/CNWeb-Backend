package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Image;

public class ImageMapper implements RowMapper<Image>{
    @Override
    public Image mapRow(ResultSet rs) {
        try {
            Image image = new Image();
            image.setId(rs.getInt("id"));
            image.setPost_id(rs.getInt("post_id"));
            image.setUrl(rs.getString("url"));
            image.setAlt(rs.getString("alt"));
            return image;
        } catch (SQLException e) {
            return null;
        }
    }
}
