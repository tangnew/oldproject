package com.exam.entity;

import java.util.Date;

public class Resources {
    private String id;

    private String name;

    private Integer type;

    private String pidPrefix;

    private String accessPath;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPidPrefix() {
        return pidPrefix;
    }

    public void setPidPrefix(String pidPrefix) {
        this.pidPrefix = pidPrefix == null ? null : pidPrefix.trim();
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath == null ? null : accessPath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}