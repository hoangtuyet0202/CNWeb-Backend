package com.cnweb.mxh.model;

import java.sql.Timestamp;
import java.util.Date;

public class Conversation {

    private Integer id;
    private String title;
    private Timestamp created_time;

    public Conversation() {
    }

    public Conversation(Integer id, String title, Timestamp created_time) {
        this.id = id;
        this.title = title;
        this.created_time = created_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }
}
