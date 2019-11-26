package com.bank.business.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerBusinessFactory {

    private RegisterCustomerBusiness registerCustomerBusiness;
    private DeleteCustomerBusiness deleteCustomerBusiness;
    private UpdateCustomerBusiness updateCustomerBusiness;
    private FindCustomersBusiness findCustomersBusiness;

    @Autowired
    public void setRegisterCustomerBusiness(RegisterCustomerBusiness registerCustomerBusiness) {
        this.registerCustomerBusiness = registerCustomerBusiness;
    }

    @Autowired
    public void setDeleteCustomerBusiness(DeleteCustomerBusiness deleteCustomerBusiness) {
        this.deleteCustomerBusiness = deleteCustomerBusiness;
    }

    @Autowired
    public void setFindCustomersBusiness(FindCustomersBusiness findCustomersBusiness) {
        this.findCustomersBusiness = findCustomersBusiness;
    }

    @Autowired
    public void setUpdateCustomerBusiness(UpdateCustomerBusiness updateCustomerBusiness) {
        this.updateCustomerBusiness = updateCustomerBusiness;
    }

    public RegisterCustomerBusiness getRegisterCustomerBusiness() {
        return registerCustomerBusiness;
    }

    public DeleteCustomerBusiness getDeleteCustomerBusiness() {
        return deleteCustomerBusiness;
    }

    public FindCustomersBusiness getFindCustomersBusiness() {
        return findCustomersBusiness;
    }

    public UpdateCustomerBusiness getUpdateCustomerBusiness() {
        return updateCustomerBusiness;
    }
}
