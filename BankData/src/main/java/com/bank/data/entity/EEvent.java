package com.bank.data.entity;

import com.bank.data.enums.OperationCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EVENT")
public class EEvent implements Serializable {
    private long id;
    private String userIP;
    private OperationCode operationCode;
    private String username;
    private List<EEventData> eventData;

    @OneToMany(mappedBy = "event")
    public List<EEventData> getEventData() {
        return eventData;
    }

    public void setEventData(List<EEventData> eventData) {
        this.eventData = eventData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
    @SequenceGenerator(name = "seq_event", sequenceName = "seq_event", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "USERIP")
    public String getUserIP() {
        return userIP;
    }


    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public OperationCode getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(OperationCode operationCode) {
        this.operationCode = operationCode;
    }

    @Column(name = "OPRTNCODE")
    public short getOperationCodeValue() {
        return operationCode.getValue();
    }

    public void setOperationCodeValue(short value) {
        this.operationCode = OperationCode.fromValue(value);
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
