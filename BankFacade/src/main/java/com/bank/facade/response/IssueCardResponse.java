package com.bank.facade.response;

import com.bank.facade.dto.PaymentApplicationTypeDto;

import java.util.Date;

public class IssueCardResponse {
    private String holderId;
    private String paymentApplicationNo;
    private String ownerCustomerNo;
    private PaymentApplicationTypeDto paymentApplicationTypeDto;
    private String carNo;
    private String pin1;
    private String pin2;
    private String cvv2;
    private Date issueDate;
    private Date expireDate;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPaymentApplicationNo() {
        return paymentApplicationNo;
    }

    public void setPaymentApplicationNo(String paymentApplicationNo) {
        this.paymentApplicationNo = paymentApplicationNo;
    }

    public String getOwnerCustomerNo() {
        return ownerCustomerNo;
    }

    public void setOwnerCustomerNo(String ownerCustomerNo) {
        this.ownerCustomerNo = ownerCustomerNo;
    }

    public PaymentApplicationTypeDto getPaymentApplicationTypeDto() {
        return paymentApplicationTypeDto;
    }

    public void setPaymentApplicationTypeDto(PaymentApplicationTypeDto paymentApplicationTypeDto) {
        this.paymentApplicationTypeDto = paymentApplicationTypeDto;
    }

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
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
}
