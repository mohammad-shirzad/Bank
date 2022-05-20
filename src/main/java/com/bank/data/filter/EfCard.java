package com.bank.data.filter;

import com.bank.data.enums.PaymentApplicationType;

public class EfCard {
    private String holderId;
    private String CustomerNo;
    private PaymentApplicationType paymentApplicationType;
    private EfDateRange issueDate;
    private EfDateRange expireDate;

    public String getHolderId() {
        return holderId;
    }

    public void setHolderId(String holderId) {
        this.holderId = holderId;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String CustomerNo) {
        this.CustomerNo = CustomerNo;
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
