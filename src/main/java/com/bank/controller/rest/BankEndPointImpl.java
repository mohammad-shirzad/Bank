package com.bank.controller.rest;

import com.bank.controller.dto.view.CardViewDto;
import com.bank.controller.dto.view.CustomerViewDto;
import com.bank.controller.request.*;
import com.bank.controller.response.*;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.data.view.EvCardIssueDetailData;
import com.bank.service.CardService;
import com.bank.service.CustomerService;
import com.bank.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
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

    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException {
        EContact contact = mapper.toEContact(request);
        long customerId = customerService.saveCustomer(contact);
        return new CreateCustomerResponse(customerId);
    }

    public DeleteCustomerByIdResponse deleteCustomer(@RequestBody DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException {
        customerService.deleteCustomerById(request.getIdentityNo());
        return new DeleteCustomerByIdResponse();
    }

    public FindCustomerResponse findCustomers(@RequestBody FindCustomerRequest request) {
        List<EContact> contacts = customerService.findCustomer(mapper.toEfContact(request.getCustomerFilterDto()));
        List<CustomerViewDto> customerViewDtos = contacts.stream().map(contact -> mapper.toCustomerViewDto(contact)).collect(Collectors.toList());
        return new FindCustomerResponse(customerViewDtos);
    }

    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) throws EntityNotExistsException, SQLException {
        EContact contact = mapper.toEContact(request);
        customerService.updateCustomer(contact);
        return new UpdateCustomerResponse();
    }

    public IssueCardResponse issueCard(@RequestBody IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EvCardIssueDetailData evCardIssueDetailData = cardService.issueCard(mapper.toECard(request));
        return mapper.toIssueCardResponse(evCardIssueDetailData);
    }

    public GetCardFullDetailsResponse getCardFullDetails(@RequestBody GetCardFullDetailsRequest request) {
        EvCard evCard = cardService.getCardFullDetails(request.getCardNo());
        CardViewDto viewDto = mapper.toCardViewDto(evCard);
        return new GetCardFullDetailsResponse(viewDto);
    }
}