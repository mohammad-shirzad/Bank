package com.bank.gateway;

import com.bank.api.dto.exception.BusinessExceptionDto;
import com.bank.api.dto.view.CardViewDto;
import com.bank.api.endpoint.BankEndPointRest;
import com.bank.api.request.*;
import com.bank.api.response.*;
import com.bank.domain.business.service.CardService;
import com.bank.domain.business.service.CustomerService;
import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityAlreadyExistsException;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.domain.data.view.EvCard;
import com.bank.domain.data.view.EvCardIssueDetailData;
import com.bank.gateway.util.ExceptionConverterUtil;
import com.bank.gateway.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bank")
public class BankEndPointRestController implements BankEndPointRest {
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

    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) throws BusinessExceptionDto {
        EContact contact = mapper.toEContact(request);
        long customerId = 0;
        try {
            customerId = customerService.saveCustomer(contact);
        } catch (EntityAlreadyExistsException e) {
            ExceptionConverterUtil.throwBusinessExceptionDto(e);
        }
        return new CreateCustomerResponse(customerId);
    }

    public DeleteCustomerByIdResponse deleteCustomer(@RequestBody DeleteCustomerByIdentityRequest request) throws BusinessExceptionDto {
        try {
            customerService.deleteCustomerById(request.getIdentityNo());
        } catch (EntityNotExistsException e) {
            ExceptionConverterUtil.throwBusinessExceptionDto(e);
        }
        return new DeleteCustomerByIdResponse();
    }

    public FindCustomerResponse findCustomers(@RequestBody FindCustomerRequest request) {
        List<EContact> contacts = customerService.findCustomer(mapper.toEfContact(request.getCustomerFilterDto()));
        List<com.bank.api.dto.view.CustomerViewDto> customerViewDtos = contacts.stream().map(contact -> mapper.toCustomerViewDto(contact)).collect(Collectors.toList());
        return new FindCustomerResponse(customerViewDtos);
    }

    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) throws BusinessExceptionDto {
        EContact contact = mapper.toEContact(request);
        try {
            customerService.updateCustomer(contact);
        } catch (EntityNotExistsException e) {
            ExceptionConverterUtil.throwBusinessExceptionDto(e);
        }
        return new UpdateCustomerResponse();
    }

    public IssueCardResponse issueCard(@RequestBody IssueCardRequest request) throws BusinessExceptionDto {
        EvCardIssueDetailData evCardIssueDetailData = null;
        try {
            evCardIssueDetailData = cardService.issueCard(mapper.toECard(request));
        } catch (EntityNotExistsException | PaymentApplicationTypeNotSupportCardWithoutHolderException e) {
            ExceptionConverterUtil.throwBusinessExceptionDto(e);
        }
        return mapper.toIssueCardResponse(evCardIssueDetailData);
    }

    public GetCardFullDetailsResponse getCardFullDetails(@RequestBody GetCardFullDetailsRequest request) {
        EvCard evCard = cardService.getCardFullDetails(request.getCardNo());
        CardViewDto viewDto = mapper.toCardViewDto(evCard);
        return new GetCardFullDetailsResponse(viewDto);
    }
}
