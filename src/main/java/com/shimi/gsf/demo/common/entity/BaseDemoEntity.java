package com.shimi.gsf.demo.common.entity;

import com.shimi.gsf.core.model.SnowflakeIdTraceableEntity;
import com.shimi.gsf.demo.user.model.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseDemoEntity extends SnowflakeIdTraceableEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    protected User createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_user_id")
    protected User updatedBy;

    @Override
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(com.shimi.gsf.core.model.User createdBy) {
        if (createdBy instanceof User) {
            this.createdBy = (User) createdBy;
        }
    }

    @Override
    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(com.shimi.gsf.core.model.User updatedBy) {
        if (updatedBy instanceof User) {
            this.updatedBy = (User) updatedBy;
        }
    }
}
