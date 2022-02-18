package com.bank.data.entity;

import com.bank.data.enums.ActionType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTDATA")
public class EEventData implements Serializable {
    private long id;
    private com.bank.data.enums.Entity entity;
    private ActionType actionType;
    private String oldValues;
    private String newValues;
    private LocalDateTime eventDate;
    private EEvent event;

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Column(name = "ACTION")
    public String getActionTypeValue() {
        return actionType.name();
    }

    public void setActionTypeValue(String actionTypeValue) {
        this.actionType = ActionType.valueOf(actionTypeValue);
    }

    @Column(name = "OLDVALS")
    public String getOldValues() {
        return oldValues;
    }

    public void setOldValues(String oldValues) {
        this.oldValues = oldValues;
    }

    @Column(name = "NEWVALS")
    public String getNewValues() {
        return newValues;
    }

    public void setNewValues(String newValues) {
        this.newValues = newValues;
    }

    @Column(name = "EVENTDAT")
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public com.bank.data.enums.Entity getEntity() {
        return entity;
    }

    @Column(name = "ENTITY")
    public String getEntityValue() {
        return entity.getValue();
    }

    public void setEntityValue(String entityName) {
        this.entity = com.bank.data.enums.Entity.fromValue(entityName);
    }

    public void setEntity(com.bank.data.enums.Entity entity) {
        this.entity = entity;
    }

    public void setEntity(String entityName) {
        this.entity = com.bank.data.enums.Entity.fromValue(entityName);
    }

    @ManyToOne
    @JoinColumn(name = "EVENTID", referencedColumnName = "ID")
    public EEvent getEvent() {
        return event;
    }

    public void setEvent(EEvent event) {
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_eventdata")
    @SequenceGenerator(name = "seq_eventdata", sequenceName = "seq_eventdata", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
