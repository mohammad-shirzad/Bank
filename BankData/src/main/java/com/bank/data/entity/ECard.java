package com.bank.data.entity;

import com.bank.data.enums.PaymentApplicationType;
import com.common.utils.AesEncrDecrUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "CARD")
@Entity
@NamedQuery(name = "card.findByCustomerNo", query = "select c from ECard c where c.holderId = :customerNumber")
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTCHNGDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class ECard extends BaseEntity {


    private String pan;


    private String paymentApplicationNumber;


    private PaymentApplicationType paymentApplicationType;


    private Long holderId;


    private String ownerCustomerNo;


    private String CVV2;


    private String pin1;

    private String pin2;


    private BigDecimal remaining;


    private Date issueDate;


    private Date expireDate;


    private EContact customer;

    @Column(name = "ISUDT", nullable = false)
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Column(name = "EXPDT", nullable = false)
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Column(name = "OWNCUSTNO")
    public String getOwnerCustomerNo() {
        return ownerCustomerNo;
    }

    public void setOwnerCustomerNo(String ownerCustomerNo) {
        this.ownerCustomerNo = ownerCustomerNo;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNCUSTNO", referencedColumnName = "CUSTNO", insertable = false, updatable = false)
    public EContact getCustomer() {
        return customer;
    }

    public void setCustomer(EContact customer) {
        this.customer = customer;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    @Id
    @Column(name = "PAN", nullable = false, length = 16)
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Column(name = "PMNTAPPNO", nullable = false)
    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    @Transient
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
        this.CVV2 = AesEncrDecrUtil.encrypt(CVV2);
    }

    @Column(name = "PIN1", nullable = false)
    public String getPin1() {
        return pin1;
    }

    public void setPin1(String pin1) {
        this.pin1 = AesEncrDecrUtil.encrypt(pin1);
    }

    @Column(name = "PIN2")
    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

}
