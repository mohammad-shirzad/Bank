package com.bank.facade.request;

public class DeleteCustomerByIdRequest {
    private long customerId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
