package com.bank.domain.business.serviceimpl;

import com.bank.domain.business.customer.DeleteCustomer;
import com.bank.domain.business.customer.FindCustomersBusiness;
import com.bank.domain.business.customer.RegisterCustomer;
import com.bank.domain.business.customer.UpdateCustomer;
import com.bank.domain.business.service.CustomerService;
import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityAlreadyExistsException;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.filter.EfContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {


    private RegisterCustomer registerCustomer;
    private DeleteCustomer deleteCustomer;
    private FindCustomersBusiness findCustomersBusiness;
    private UpdateCustomer updateCustomer;

    @Autowired
    public void setRegisterCustomer(RegisterCustomer registerCustomer) {
        this.registerCustomer = registerCustomer;
    }
    @Autowired
    public void setDeleteCustomer(DeleteCustomer deleteCustomer) {
        this.deleteCustomer = deleteCustomer;
    }
    @Autowired
    public void setFindCustomersBusiness(FindCustomersBusiness findCustomersBusiness) {
        this.findCustomersBusiness = findCustomersBusiness;
    }
    @Autowired
    public void setUpdateCustomer(UpdateCustomer updateCustomer) {
        this.updateCustomer = updateCustomer;
    }

    @Override
    public long saveCustomer(EContact customer) throws EntityAlreadyExistsException {

        return registerCustomer.execute(customer);
    }

    @Override
    public void deleteCustomerById(String identityNo) throws EntityNotExistsException {
        deleteCustomer.execute(identityNo);
    }

    @Override
    public void updateCustomer(EContact customer) throws EntityNotExistsException {
        updateCustomer.execute(customer);
    }

    @Override
    public List<EContact> findCustomer(EfContact efContact) {
        return findCustomersBusiness.execute(efContact);
    }
}
