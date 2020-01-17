package com.bank.data.entity;

import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(name = "TRX")
@Entity
public class ETransaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_seq")
    @SequenceGenerator(name = "trx_seq", sequenceName = "TRX_SEQ", allocationSize = 1000)
    @Column(name = "ID")
    private long id;

    @Column(name = "PRTRCNO", nullable = false)
    private String peerTraceNumber;

    @Column(name = "SRCCRDPAN")
    private String sourceCardPAN;

    @Column(name = "SRCCRDPMNTAPPNO")
    private String sourceCardPaymentApplicationNumber;

    @Column(name = "DSTCRDPAN")
    private String destinationCardPAN;

    @Column(name = "DSTCRDPMNTAPPNO")
    private String destinationCardPaymentApplicationNumber;

    @Column(name = "AMNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "STS", nullable = false)
    private TransactionStatus status;

    @Column(name = "OCRNCTIM", nullable = false)
    private Timestamp occuranceTime;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getPeerTraceNumber() {
        return peerTraceNumber;
    }

    public void setPeerTraceNumber(String peerTraceNumber) {
        this.peerTraceNumber = peerTraceNumber;
    }

    public String getSourceCardPAN() {
        return sourceCardPAN;
    }

    public void setSourceCardPAN(String sourceCardPAN) {
        this.sourceCardPAN = sourceCardPAN;
    }

    public String getSourceCardPaymentApplicationNumber() {
        return sourceCardPaymentApplicationNumber;
    }

    public void setSourceCardPaymentApplicationNumber(String sourceCardPaymentApplicationNumber) {
        this.sourceCardPaymentApplicationNumber = sourceCardPaymentApplicationNumber;
    }

    public String getDestinationCardPAN() {
        return destinationCardPAN;
    }

    public void setDestinationCardPAN(String destinationCardPAN) {
        this.destinationCardPAN = destinationCardPAN;
    }

    public String getDestinationCardPaymentApplicationNumber() {
        return destinationCardPaymentApplicationNumber;
    }

    public void setDestinationCardPaymentApplicationNumber(String destinationCardPaymentApplicationNumber) {
        this.destinationCardPaymentApplicationNumber = destinationCardPaymentApplicationNumber;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Timestamp getOccuranceTime() {
        return occuranceTime;
    }

    public void setOccuranceTime(Timestamp occuranceTime) {
        this.occuranceTime = occuranceTime;
    }

}
