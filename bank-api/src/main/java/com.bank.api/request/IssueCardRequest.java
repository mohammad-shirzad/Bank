package com.bank.api.request;

import com.bank.controller.dto.enumeration.PaymentApplicationTypeDto;

public class IssueCardRequest extends ServiceRequest{
    private String paymentApplicationNumber;
    private String customerNo;
    private PaymentApplicationTypeDto paymentApplicationType;
    private Long holderId;

    public String getPaymentApplicationNumber() {
        return paymentApplicationNumber;
    }

    public void setPaymentApplicationNumber(String paymentApplicationNumber) {
        this.paymentApplicationNumber = paymentApplicationNumber;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String CustomerNo) {
        this.customerNo = CustomerNo;
    }

    public PaymentApplicationTypeDto getPaymentApplicationType() {
        return paymentApplicationType;
    }

    public void setPaymentApplicationType(PaymentApplicationTypeDto paymentApplicationType) {
        this.paymentApplicationType = paymentApplicationType;
    }

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }

    @Override
    public String toString() {
        return "IssueCardRequest{" +
                "paymentApplicationNumber='" + paymentApplicationNumber + '\'' +
                ", CustomerNo='" + customerNo + '\'' +
                ", paymentApplicationType=" + paymentApplicationType +
                ", holderId=" + holderId +
                "} " + super.toString();
    }
}
