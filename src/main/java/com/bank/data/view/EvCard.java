package com.bank.data.view;

import com.bank.data.enums.PaymentApplicationType;

import java.util.Date;

public class EvCard {
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerIdentityNo;
    private String customerNo;
    private String cardNo;
    private String cvv2;
    private Date issueDate;
    private Date expireDate;
    private PaymentApplicationType paymentApplicationType;
    private String paymentApplicationNumber;
    private Long holderId;


    public EvCard(String ownerFirstName, String ownerLastName, String ownerIdentityNo, String cardNo, String cvv2, Date issueDate, Date expireDate, PaymentApplicationType paymentApplicationType, String paymentApplicationNumber, Long holderId, String customerNo) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerIdentityNo = ownerIdentityNo;
        this.customerNo = customerNo;
        this.cardNo = cardNo;
        this.cvv2 = cvv2;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.paymentApplicationType = paymentApplicationType;
        this.paymentApplicationNumber = paymentApplicationNumber;
        this.holderId = holderId;
    }


    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String CustomerNo) {
        this.customerNo = CustomerNo;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerIdentityNo() {
        return ownerIdentityNo;
    }

    public void setOwnerIdentityNo(String ownerIdentityNo) {
        this.ownerIdentityNo = ownerIdentityNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

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

    public PaymentApplicationType getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public PaymentApplicationType getPaymentApplicationTypeValue() {
        return PaymentApplicationType.fromValue(paymentApplicationType.getValue());
    }

    public void setPaymentApplicationType(PaymentApplicationType paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
    }

    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }
}
