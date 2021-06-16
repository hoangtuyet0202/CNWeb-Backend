package com.cnweb.mxh.model;

import java.sql.Timestamp;
import java.util.Date;

public class Post {
    private Integer id;
    private Integer user_id;
    private Timestamp created_time;
    private String content;
    private Integer scope; // scope of post 0 : public, 1 : friends can see, 2 : private

    public Post() {
    }


    public Post(Integer id, Integer user_id, Timestamp created_time, String content, Integer scope) {
        this.id = id;
        this.user_id = user_id;
        this.created_time = created_time;
        this.content = content;
        this.scope = scope;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}
