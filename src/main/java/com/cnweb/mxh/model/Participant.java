package com.cnweb.mxh.model;

public class Participant {
    private Integer id;
    private Integer conversation_id;
    private Integer user_id;
    private Boolean status;

    public Participant() {
    }

    public Participant(Integer conversation_id, Integer user_id, Boolean status) {
        this.conversation_id = conversation_id;
        this.user_id = user_id;
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
