package com.bank.data.entity;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    private Date lastModificationDate;

    private Date modifiedBy;

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
