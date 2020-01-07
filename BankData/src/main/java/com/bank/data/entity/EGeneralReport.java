package com.bank.data.entity;

import com.bank.data.enums.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Table(name = "GNRLRPRT")
@javax.persistence.Entity
public class EGeneralReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generalReport_seq")
    @SequenceGenerator(name = "generalReport_seq", sequenceName = "GENERALREPORT_SEQ", allocationSize = 1000)
    @Column(name = "ID")
    private long id;

    @Column(name = "IP", nullable = false)
    private String agent_IP;

    @Column(name = "ENTITY", nullable = false)
    private Entity entity;


    @Column(name = "CHNGTIM", nullable = false)
    private Date changeTime;

    @Transient
    private List<EDetailedReport> EDetailedReports;

    @Column(name = "LSTCHNGTIM", nullable = false)
    private Timestamp lastChangeTime;

    public EGeneralReport() {
    }

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

    public List<EDetailedReport> getEDetailedReports() {
        return EDetailedReports;
    }

    public void setEDetailedReports(List<EDetailedReport> EDetailedReports) {
        this.EDetailedReports = EDetailedReports;
    }

    public Timestamp getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Timestamp lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public EGeneralReport(String agent_IP) {
        this.agent_IP = agent_IP;
    }

    public EGeneralReport(String agent_IP, Entity entity, Date changeTime, List<EDetailedReport> EDetailedReports, Timestamp lastChangeTime) {
        this.agent_IP = agent_IP;
        this.entity = entity;
        this.changeTime = changeTime;
        this.EDetailedReports = EDetailedReports;
        this.lastChangeTime = lastChangeTime;
    }
}
