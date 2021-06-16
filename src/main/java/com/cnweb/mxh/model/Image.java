package com.cnweb.mxh.model;

public class Image {
    private Integer id;
    private Integer post_id;
    private String url;
    private String alt;

    public Image() {
    }

    public Image(Integer id, Integer post_id, String url, String alt) {
        this.id = id;
        this.post_id = post_id;
        this.url = url;
        this.alt = alt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
