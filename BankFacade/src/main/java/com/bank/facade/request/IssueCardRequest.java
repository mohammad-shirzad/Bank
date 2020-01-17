package com.bank.facade.request;

import com.bank.facade.dto.PaymentApplicationTypeDto;

public class IssueCardRequest {
    private String paymentApplicationNo;
    private String ownerCustomerNo;
    private PaymentApplicationTypeDto paymentApplicationTypeDto;
    private String holderIdentityNo;

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

    public String getHolderIdentityNo() {
        return holderIdentityNo;
    }

    public void setHolderIdentityNo(String holderIdentityNo) {
        this.holderIdentityNo = holderIdentityNo;
    }
}
