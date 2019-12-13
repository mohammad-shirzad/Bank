package com.bank.facade.facadeImpl;

import com.bank.data.entity.ECustomer;
import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.data.filter.EfCustomer;
import com.bank.facade.dto.CustomerFilterDto;
import com.bank.facade.facade.CustomerFacade;
import com.bank.facade.mapper.EntityMapper;
import com.bank.facade.request.CreateCustomerRequest;
import com.bank.facade.request.DeleteCustomerByIdentityRequest;
import com.bank.facade.request.FindCustomerRequest;
import com.bank.facade.request.UpdateCustomerRequest;
import com.bank.facade.response.CreateCustomerResponse;
import com.bank.facade.response.DeleteCustomerByIdResponse;
import com.bank.facade.response.FindCustomerResponse;
import com.bank.facade.response.UpdateCustomerResponse;
import com.bank.service.CustomerService;
import com.common.utils.singleton.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "CustomerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException {
        if (request == null)
            return null;
        ECustomer customer = DozerMapper.getDozerBeanMapper().map(request, ECustomer.class);
        customer = customerService.saveCustomer(customer);
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.seteCustomer(customer);
        return response;

    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws CustomerNotExistsException {
        if (request == null)
            return null;
        customerService.deleteCustomerById(request.getIdentityNo());
        return new DeleteCustomerByIdResponse();
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws CustomerNotExistsException {
        ECustomer customer = EntityMapper.toECustomer(request);
        customerService.updateCustomer(customer);
        return new UpdateCustomerResponse();
    }

    @Override
    public FindCustomerResponse findCustomer(FindCustomerRequest request) {

        List<ECustomer> result = customerService.findCustomer(EntityMapper.toEfCustomer(request.getCustomerFilterDto()));
        FindCustomerResponse response = new FindCustomerResponse();
        response.seteCustomer(result);
        return response;
    }
}
