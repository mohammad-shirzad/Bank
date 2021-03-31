package com.bank.facade.facadeImpl;

import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.facade.facade.BankFacade;
import com.bank.facade.mapper.EntityMapper;
import com.bank.facade.request.*;
import com.bank.facade.response.*;
import com.bank.service.CardService;
import com.bank.service.CustomerService;
import com.common.utils.singleton.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException {
        if (request == null)
            return null;
        EContact customer = DozerMapper.getDozerBeanMapper().map(request, EContact.class);
        customer = customerService.saveCustomer(customer);
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.seteContact(customer);
        return response;

    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException {
        if (request == null)
            return null;
        customerService.deleteCustomerById(request.getIdentityNo());
        return new DeleteCustomerByIdResponse();
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException {
        EContact customer = EntityMapper.toECustomer(request);
        customerService.updateCustomer(customer);
        return new UpdateCustomerResponse();
    }

    @Override
    public FindCustomerResponse findCustomer(FindCustomerRequest request) {

        List<EContact> result = customerService.findCustomer(EntityMapper.toEfCustomer(request.getCustomerFilterDto()));
        FindCustomerResponse response = new FindCustomerResponse();
        response.setEvCustomer(EntityMapper.toEvCustomer(result));
        return response;
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        ECard card = EntityMapper.toECard(request);
        card = cardService.saveCard(card);
        return EntityMapper.toIssueCardResponse(card);
    }

    @Override
    public GetCardFullDetailsResponse getCardFullDetails(GetCardFullDetailsRequest request) {
        EvCard evCard = cardService.getCardFullDetails(request.getPan());
        GetCardFullDetailsResponse response = new GetCardFullDetailsResponse();
        response.setEvCard(evCard);
        return response;
    }
}
