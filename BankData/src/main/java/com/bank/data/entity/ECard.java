package com.bank.data.entity;

import com.bank.data.enums.PaymentApplicationType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "CARDS")
@Entity
@NamedQuery(name = "card.findByCustomerNo", query = "select c from ECard c where c.holderId = :customerNumber")
public class ECard extends BaseEntity {

    @Id
    @Column(name = "PAN", nullable = false, length = 16)
    private String pan;

    @Column(name = "PMNTAPPNO", nullable = false)
    private String paymentApplicationNumber;

    @Transient
    private PaymentApplicationType paymentApplicationType;

    @Column(name = "HLDRID")
    private String holderId;

    @Column(name = "OWNCUSTNO")
    private String ownerCustomerNo;

    @Column(nullable = false)
    private String CVV2;

    @Column(name = "PIN1", nullable = false)
    private String pin1;

    @Column(name = "PIN2")
    private String pin2;

    @Column(name = "RMNING")
    private BigDecimal remaining;

    @Column(name = "ISUDT", nullable = false)
    private Date issueDate;

    @Column(name = "EXPDT", nullable = false)
    private Date expireDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNCUSTNO", referencedColumnName = "CUSTNO", insertable = false, updatable = false)
    private ECustomer customer;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

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

    @Column(name = "PMNTAPPTYP", nullable = false)
    @Access(value = AccessType.PROPERTY)
    public int getPaymentApplicationTypeValue() {
        return paymentApplicationType.getValue();
    }

    public void setPaymentApplicationTypeValue(Integer paymentApplicationType) {
        this.paymentApplicationType = PaymentApplicationType.fromValue(paymentApplicationType);
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
