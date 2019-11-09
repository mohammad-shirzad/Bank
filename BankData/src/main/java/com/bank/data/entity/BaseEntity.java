package com.bank.data.entity;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {
    private Timestamp lastModificationDate;

    private Timestamp modifiedBy;

    public Timestamp getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Timestamp lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Timestamp getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Timestamp modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
