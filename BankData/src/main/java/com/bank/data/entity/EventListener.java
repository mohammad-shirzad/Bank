package com.bank.data.entity;

import org.aspectj.lang.annotation.After;

import javax.persistence.*;

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
