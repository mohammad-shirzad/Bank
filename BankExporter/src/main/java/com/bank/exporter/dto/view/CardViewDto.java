package com.bank.exporter.dto.view;

import com.bank.data.enums.PaymentApplicationType;
import com.bank.exporter.dto.enumeration.PaymentApplicationTypeDto;

import java.util.Date;

public class CardViewDto {
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerIdentityNo;
    private String ownerCustomerNo;
    private String cardNo;
    private String cvv2;
    private Date issueDate;
    private Date expireDate;
    private PaymentApplicationTypeDto paymentApplicationType;
    private String paymentApplicationNumber;
    private Long holderId;


    public String getOwnerCustomerNo() {
        return ownerCustomerNo;
    }

    public void setOwnerCustomerNo(String ownerCustomerNo) {
        this.ownerCustomerNo = ownerCustomerNo;
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

    public PaymentApplicationTypeDto getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationTypeDto paymentApplicationType) {
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

    @Override
    public String toString() {
        return "CardViewDto{" +
                "ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", ownerIdentityNo='" + ownerIdentityNo + '\'' +
                ", ownerCustomerNo='" + ownerCustomerNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", paymentApplicationType=" + paymentApplicationType +
                ", paymentApplicationNumber='" + paymentApplicationNumber + '\'' +
                ", holderId=" + holderId +
                '}';
    }
}
