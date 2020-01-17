package com.bank.facade.facadeImpl;

import com.bank.data.entity.ECard;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.facade.facade.BankFacade;
import com.bank.facade.mapper.EntityMapper;
import com.bank.facade.mapper.EnumMapper;
import com.bank.facade.request.*;
import com.bank.facade.response.*;
import com.bank.service.CardService;
import com.bank.service.CustomerService;
import com.common.utils.singleton.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component(value = "CustomerFacade")
public class BankFacadeImpl implements BankFacade {

    private CustomerService customerService;
    private CardService cardService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException {
        if (request == null)
            return null;
        ECustomer customer = DozerMapper.getDozerBeanMapper().map(request, ECustomer.class);
        customer = customerService.saveCustomer(customer);
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.seteCustomer(customer);
        return response;

    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException {
        if (request == null)
            return null;
        customerService.deleteCustomerById(request.getIdentityNo());
        return new DeleteCustomerByIdResponse();
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException, SQLException {
        ECustomer customer = EntityMapper.toECustomer(request);
        customerService.updateCustomer(customer);
        return new UpdateCustomerResponse();
    }

    @Override
    public FindCustomerResponse findCustomer(FindCustomerRequest request) throws SQLException {

        List<ECustomer> result = customerService.findCustomer(EntityMapper.toEfCustomer(request.getCustomerFilterDto()));
        FindCustomerResponse response = new FindCustomerResponse();
        response.setEvCustomer(EntityMapper.toEvCustomer(result));
        return response;
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException {
        ECard card = EntityMapper.toECard(request);
        card = cardService.saveCard(card);
        return EntityMapper.toIssueCardResponse(card);
    }
}
