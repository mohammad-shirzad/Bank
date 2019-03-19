package entity;

public class DetailedReport extends Report {
    private int id;
    private String entityField;
    private String oldData;
    private String newData;
    private GeneralReport generalReport;

    public GeneralReport getGeneralReport() {
        return generalReport;
    }

    public void setGeneralReport(GeneralReport generalReport) {
        this.generalReport = generalReport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public DetailedReport() {
    }

    public DetailedReport(int id, String entityField, String oldData, String newData) {
        this.id = id;
        this.entityField = entityField;
        this.oldData = oldData;
        this.newData = newData;
    }
}
