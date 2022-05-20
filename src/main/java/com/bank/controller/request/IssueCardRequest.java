package com.bank.controller.request;

import com.bank.controller.dto.enumeration.PaymentApplicationTypeDto;

public class IssueCardRequest extends ServiceRequest{
    private String paymentApplicationNumber;
    private String CustomerNo;
    private PaymentApplicationTypeDto paymentApplicationType;
    private Long holderId;

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
                ", CustomerNo='" + CustomerNo + '\'' +
                ", paymentApplicationType=" + paymentApplicationType +
                ", holderId=" + holderId +
                "} " + super.toString();
    }
}
