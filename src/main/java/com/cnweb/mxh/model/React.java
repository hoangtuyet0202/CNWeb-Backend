package com.cnweb.mxh.model;

import java.sql.Timestamp;
import java.util.Date;

public class React {
    private Integer id;
    private Integer post_id;
    private Integer user_id;
    private Timestamp created_time;
    private Boolean status;

    public React() {
    }

    public React(Integer post_id, Integer user_id, Timestamp created_time, Boolean status) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.created_time = created_time;
        this.status = status;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
