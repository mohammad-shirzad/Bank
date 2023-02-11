package com.bank.controller.request;

public class DeleteCustomerByIdentityRequest extends ServiceRequest{
    private String identityNo;

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Override
    public String toString() {
        return "DeleteCustomerByIdentityRequest{" +
                "identityNo='" + identityNo + '\'' +
                "} " + super.toString();
    }
}
