package com.bank.business.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerBusinessFactory {

    private RegisterCustomerBusiness registerCustomerBusiness;
    private DeleteCustomerBusiness deleteCustomerBusiness;

    @Autowired
    public void setRegisterCustomerBusiness(RegisterCustomerBusiness registerCustomerBusiness) {
        this.registerCustomerBusiness = registerCustomerBusiness;
    }

    @Autowired
    public void setDeleteCustomerBusiness(DeleteCustomerBusiness deleteCustomerBusiness) {
        this.deleteCustomerBusiness = deleteCustomerBusiness;
    }

    public RegisterCustomerBusiness getRegisterCustomerBusiness() {
        return registerCustomerBusiness;
    }

    public DeleteCustomerBusiness getDeleteCustomerBusiness() {
        return deleteCustomerBusiness;
    }
}
