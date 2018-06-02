package com.exam.entity;

import java.util.Date;

public class RelAccountRole {
    private String id;

    private String fkRoleId;

    private String fkAccountId;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(String fkRoleId) {
        this.fkRoleId = fkRoleId == null ? null : fkRoleId.trim();
    }

    public String getFkAccountId() {
        return fkAccountId;
    }

    public void setFkAccountId(String fkAccountId) {
        this.fkAccountId = fkAccountId == null ? null : fkAccountId.trim();
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
}