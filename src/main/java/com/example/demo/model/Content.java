package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class Content {

    public Content(Integer id, String title, String desc, Status status, Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
        this.contentType = contentType;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.url = url;
    }

    Integer id;
    @NotBlank
    String title;
    String desc;
    Status status;
    Type contentType;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;
    String url;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getContentType() {
        return contentType;
    }

    public void setContentType(Type contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
