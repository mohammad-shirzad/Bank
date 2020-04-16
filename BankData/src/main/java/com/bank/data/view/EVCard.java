package com.bank.data.view;

import com.bank.data.enums.PaymentApplicationType;

import java.util.Date;

public class EVCard {
    private String firstName;
    private String lastName;
    private String IdentityNo;
    private String cardNo;
    private String cvv2;
    private Date issueDate;
    private Date expireDate;
    private PaymentApplicationType paymentApplicationType;

    public EVCard(String firstName, String lastName, String identityNo, String cardNo, String cvv2, Date issueDate, Date expireDate, PaymentApplicationType paymentApplicationType) {
        this.firstName = firstName;
        this.lastName = lastName;
        IdentityNo = identityNo;
        this.cardNo = cardNo;
        this.cvv2 = cvv2;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.paymentApplicationType = paymentApplicationType;
    }

    public PaymentApplicationType getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationType paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
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

    public String getIdentityNo() {
        return IdentityNo;
    }

    public void setIdentityNo(String identityNo) {
        IdentityNo = identityNo;
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
}
