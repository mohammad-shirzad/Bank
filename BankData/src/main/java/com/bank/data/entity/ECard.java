package com.bank.data.entity;

import com.bank.data.enums.PaymentApplicationType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "CARDS")
@Entity
@NamedQuery(name = "card.findByCustomerNo", query = "select c from ECard c where c.holderId = :customerNumber")
public class ECard extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @SequenceGenerator(name = "card_seq", sequenceName = "CARD_SEQ")
    @Column(name = "ID")
    private long id;

    @Column(name = "PAN", nullable = false, length = 16)
    private String pan;

    @Column(name = "PMNTAPPNO", nullable = false)
    private String paymentApplicationNumber;

    @Column(name = "PMNTAPPTYP", nullable = false)
    private PaymentApplicationType paymentApplicationType;

    @Column(name = "HLDRID")
    private String holderId;

    @Column(name = "OWNCUSTNO", nullable = false)
    private String ownerCustomerNo;

    @Column(nullable = false)
    private String CVV2;

    @Column(name = "PIN1", nullable = false)
    private String pin1;

    @Column(name = "PIN2")
    private String pin2;

    @Column(name = "RMNING", nullable = false)
    private BigDecimal remaining;

    @Transient
    private ECustomer customer;

    public String getOwnerCustomerNo() {
        return ownerCustomerNo;
    }

    public void setOwnerCustomerNo(String ownerCustomerNo) {
        this.ownerCustomerNo = ownerCustomerNo;
    }

    public ECustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ECustomer customer) {
        this.customer = customer;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public long getId() {
        return id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    public PaymentApplicationType getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationType paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
    }

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String customerNumber) {
        this.holderId = customerNumber;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public String getPin1() {
        return pin1;
    }

    public void setPin1(String pin1) {
        this.pin1 = pin1;
    }

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

}
