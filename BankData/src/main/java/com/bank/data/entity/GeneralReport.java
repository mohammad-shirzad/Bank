package com.bank.data.entity;

import com.bank.data.enums.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Table(name = "GNRLRPRT")
@javax.persistence.Entity
public class GeneralReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "IP", nullable = false)
    private String agent_IP;

    @Column(name = "ENTITY", nullable = false)
    private Entity entity;


    @Column(name = "CHNGTIM", nullable = false)
    private Date changeTime;

    @Transient
    private List<DetailedReport> detailedReports;

    @Column(name = "LSTCHNGTIM", nullable = false)
    private Timestamp lastChangeTime;

    public long getId() {
        return id;
    }

    public String getAgent_IP() {
        return agent_IP;
    }

    public void setAgent_IP(String agent_IP) {
        this.agent_IP = agent_IP;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public List<DetailedReport> getDetailedReports() {
        return detailedReports;
    }

    public void setDetailedReports(List<DetailedReport> detailedReports) {
        this.detailedReports = detailedReports;
    }

    public Timestamp getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Timestamp lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public GeneralReport(String agent_IP) {
        this.agent_IP = agent_IP;
    }

    public GeneralReport(String agent_IP, Entity entity, Date changeTime, List<DetailedReport> detailedReports, Timestamp lastChangeTime) {
        this.agent_IP = agent_IP;
        this.entity = entity;
        this.changeTime = changeTime;
        this.detailedReports = detailedReports;
        this.lastChangeTime = lastChangeTime;
    }
}
