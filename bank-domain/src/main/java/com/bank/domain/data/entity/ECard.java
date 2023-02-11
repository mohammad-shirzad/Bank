package com.bank.domain.data.entity;

import com.bank.domain.data.enums.PaymentApplicationType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "CARD")
@Entity
@NamedQuery(name = "card.findByCustomerNo", query = "select c from ECard c where c.holderId = :customerNumber")
public class ECard implements Serializable {


    private String cardNo;


    private String paymentApplicationNumber;


    private PaymentApplicationType paymentApplicationType;


    private Long holderId;


    private String customerNo;


    private String CVV2;


    private String firstPin;

    private String secondPin;


    private Date issueDate;


    private Date expireDate;


    private EContact customer;

    @Column(name = "custno")
    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @Column(name = "ISUDT", nullable = false)
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Column(name = "EXPDT", nullable = false)
    @Temporal(value = TemporalType.DATE)
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "HLDRID", referencedColumnName = "ID", insertable = false, updatable = false)
    public EContact getCustomer() {
        return customer;
    }

    public void setCustomer(EContact customer) {
        this.customer = customer;
    }

    @Id
    @Column(name = "CARDNO", nullable = false, length = 16)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String pan) {
        this.cardNo = pan;
    }

    @Column(name = "PMNTAPPNO", nullable = false)
    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    @Column(name = "PMNTAPPTYP")
    public PaymentApplicationType getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationType paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
    }

    @Column(name = "HLDRID")
    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }

    @Column(name = "CVV", nullable = false)
    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    @Column(name = "PIN1", nullable = false)
    public String getFirstPin() {
        return firstPin;
    }

    public void setFirstPin(String pin1) {
        this.firstPin = pin1;
    }

    @Column(name = "PIN2")
    public String getSecondPin() {
        return secondPin;
    }

    public void setSecondPin(String pin2) {
        this.secondPin = pin2;
    }

}
