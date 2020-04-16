package com.bank.data.filter;

import com.bank.data.enums.PaymentApplicationType;

import java.util.Date;

public class EfCard {
    private String holderId;
    private String ownerCustomerNo;
    private PaymentApplicationType paymentApplicationType;
    private EfDateRange issueDate;
    private EfDateRange expireDate;

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    public String getOwnerCustomerNo() {
        return ownerCustomerNo;
    }

    public void setOwnerCustomerNo(String ownerCustomerNo) {
        this.ownerCustomerNo = ownerCustomerNo;
    }

    public PaymentApplicationType getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationType paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
    }

    public EfDateRange getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(EfDateRange issueDate) {
        this.issueDate = issueDate;
    }

    public EfDateRange getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(EfDateRange expireDate) {
        this.expireDate = expireDate;
    }
}
