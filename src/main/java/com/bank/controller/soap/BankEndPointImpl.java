package com.bank.controller.soap;

import com.bank.controller.dto.view.CardViewDto;
import com.bank.controller.dto.view.CustomerViewDto;
import com.bank.controller.request.*;
import com.bank.controller.response.*;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EvCard;
import com.bank.data.view.EvCardIssueDetailData;
import com.bank.service.CardService;
import com.bank.service.CustomerService;
import com.bank.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "BankSOAPEndpoint")
@WebService(endpointInterface = "com.bank.controller.soap.BankEndPoint")
public class BankEndPointImpl implements BankEndPoint {

    private CustomerService customerService;
    private CardService cardService;
    private ObjectMapper mapper = ObjectMapper.INSTANCE;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException {
        EContact contact = mapper.toEContact(request);
        long customerId = customerService.saveCustomer(contact);
        return new CreateCustomerResponse(customerId);
    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomer(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException {
        customerService.deleteCustomerById(request.getIdentityNo());
        return new DeleteCustomerByIdResponse();
    }

    @Override
    public FindCustomerResponse findCustomers(FindCustomerRequest request) {
        List<EContact> contacts = customerService.findCustomer(mapper.toEfContact(request.getCustomerFilterDto()));
        List<CustomerViewDto> customerViewDtos = contacts.stream().map(contact -> mapper.toCustomerViewDto(contact)).collect(Collectors.toList());
        return new FindCustomerResponse(customerViewDtos);

    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException {
        EContact contact = mapper.toEContact(request);
        customerService.updateCustomer(contact);
        return new UpdateCustomerResponse();
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EvCardIssueDetailData evCardIssueDetailData = cardService.issueCard(mapper.toECard(request));
        return mapper.toIssueCardResponse(evCardIssueDetailData);
    }

    @Override
    public GetCardFullDetailsResponse getCardFullDetails(GetCardFullDetailsRequest request) {
        EvCard evCard = cardService.getCardFullDetails(request.getCardNo());
        CardViewDto viewDto = mapper.toCardViewDto(evCard);
         return new GetCardFullDetailsResponse(viewDto);
    }
}
