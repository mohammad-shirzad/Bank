package entity;

import java.util.Date;
import java.util.List;

public class GeneralReport extends Report {
    private int id;
    private String agent_IP;
    private Date changeTime;
    private int entity;
    private int entityId;
    private List<DetailedReport> detailedReports;

    private static final GeneralReport GENERAL_REPORT = new GeneralReport();

    public List<DetailedReport> getDetailedReports() {
        return detailedReports;
    }

    public void setDetailedReports(List<DetailedReport> detailedReports) {
        this.detailedReports = detailedReports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgent_IP() {
        return agent_IP;
    }

    public void setAgent_IP(String agent_IP) {
        this.agent_IP = agent_IP;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public int getEntity() {
        return entity;
    }

    public void setEntity(int entity) {
        this.entity = entity;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public GeneralReport() {
    }

    public GeneralReport(String agent_IP, Date changeTime, int entity, int entityId) {
        this.agent_IP = agent_IP;
        this.changeTime = changeTime;
        this.entity = entity;
        this.entityId = entityId;
    }

    public GeneralReport(int id, String agent_IP, Date changeTime, int entity, int entityId) {
        this.id = id;
        this.agent_IP = agent_IP;
        this.changeTime = changeTime;
        this.entity = entity;
        this.entityId = entityId;
    }
}
