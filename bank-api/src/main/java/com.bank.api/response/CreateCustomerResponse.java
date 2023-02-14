package com.bank.api.response;


public class CreateCustomerResponse extends ServiceResponse {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CreateCustomerResponse(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreateCustomerResponse{" +
                "id=" + id +
                "} " + super.toString();
    }
}
