package com.bank.data.entity;

import javax.persistence.*;

@Table(name = "DTLRPRT")
@Entity
public class DetailedReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ENTITYFLD", nullable = false)
    private String entityField;

    @Column(name = "OLDDT", nullable = false)
    private String oldData;

    @Column(name = "NEWDT", nullable = false)
    private String newData;

    public long getId() {
        return id;
    }

    public String getEntityField() {
        return entityField;
    }

    public void setEntityField(String entityField) {
        this.entityField = entityField;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public DetailedReport(String entityField) {
        this.entityField = entityField;
    }

    public DetailedReport(String entityField, String oldData, String newData) {
        this.entityField = entityField;
        this.oldData = oldData;
        this.newData = newData;
    }
}
