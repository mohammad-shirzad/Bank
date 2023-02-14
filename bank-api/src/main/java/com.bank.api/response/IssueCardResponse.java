package com.bank.api.response;

import com.bank.controller.dto.enumeration.PaymentApplicationTypeDto;

import java.util.Date;

public class IssueCardResponse extends ServiceResponse{
    private String holderId;
    private String paymentApplicationNumber;
    private String CustomerNo;
    private PaymentApplicationTypeDto paymentApplicationTypeDto;
    private String carNo;
    private String pin1;
    private String pin2;
    private String CVV2;
    private Date issueDate;
    private Date expireDate;
    private String firstName;
    private String lastName;

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String CustomerNo) {
        this.CustomerNo = CustomerNo;
    }

    public PaymentApplicationTypeDto getPaymentApplicationTypeDto() {
        return paymentApplicationTypeDto;
    }

    public void setPaymentApplicationTypeDto(PaymentApplicationTypeDto paymentApplicationTypeDto) {
        this.paymentApplicationTypeDto = paymentApplicationTypeDto;
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

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
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

    @Override
    public String toString() {
        return "IssueCardResponse{" +
                "holderId='" + holderId + '\'' +
                ", paymentApplicationNumber='" + paymentApplicationNumber + '\'' +
                ", CustomerNo='" + CustomerNo + '\'' +
                ", paymentApplicationTypeDto=" + paymentApplicationTypeDto +
                ", carNo='" + carNo + '\'' +
                ", pin1='" + pin1 + '\'' +
                ", pin2='" + pin2 + '\'' +
                ", CVV2='" + CVV2 + '\'' +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
