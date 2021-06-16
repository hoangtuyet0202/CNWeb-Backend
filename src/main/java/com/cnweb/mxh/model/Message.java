package com.cnweb.mxh.model;

import java.sql.Timestamp;

public class Message {
    private Integer id;
    private Integer conversation_id;
    private Integer user_id;
    private String content;
    private Timestamp created_time;
    private Boolean status;

    public Message() {
    }

    public Message(Integer conversation_id, Integer user_id, String content, Timestamp created_time, Boolean status) {
        this.conversation_id = conversation_id;
        this.user_id = user_id;
        this.content = content;
        this.created_time = created_time;
        this.status = status;
    }

    public Integer getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Integer conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
