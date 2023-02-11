package com.bank.domain.data.entity;

import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EventListener {

    @PrePersist
    private void beforeInsert(Object object) {

    }

    @PreUpdate
    private void beforeUpdate(Object object) {

    }

    @PostUpdate
    private void afterUpdate(Object object) {

    }

    @PreRemove
    private void beforeRemove(Object object) {

    }

}
