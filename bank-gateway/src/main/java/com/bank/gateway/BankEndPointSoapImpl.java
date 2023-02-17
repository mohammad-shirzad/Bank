package com.bank.gateway;

import com.bank.api.dto.exception.EntityAlreadyExistsExceptionDto;
import com.bank.api.dto.exception.EntityNotExistsExceptionDto;
import com.bank.api.dto.exception.HolderExceptionDto;
import com.bank.api.dto.exception.PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto;
import com.bank.api.dto.view.CardViewDto;
import com.bank.api.endpoint.BankEndPointSoap;
import com.bank.api.request.*;
import com.bank.api.response.*;
import com.bank.domain.business.service.CardService;
import com.bank.domain.business.service.CustomerService;
import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.BusinessException;
import com.bank.domain.data.view.EvCard;
import com.bank.domain.data.view.EvCardIssueDetailData;
import com.bank.gateway.util.ExceptionConverterUtil;
import com.bank.gateway.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "BankEndPointSoapImpl")
@WebService(endpointInterface = "com.bank.gateway.controller.soap.BankEndPointSoapImpl")
public class BankEndPointSoapImpl implements BankEndPointSoap {

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
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto, EntityNotExistsExceptionDto, HolderExceptionDto, EntityAlreadyExistsExceptionDto {
        EContact contact = mapper.toEContact(request);
        long customerId = 0;
        try {
            customerId = customerService.saveCustomer(contact);
        } catch (BusinessException e) {
            ExceptionConverterUtil.throwDtoException(e);
        }
        return new CreateCustomerResponse(customerId);
    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomer(DeleteCustomerByIdentityRequest request) throws EntityNotExistsExceptionDto, PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto, HolderExceptionDto, EntityAlreadyExistsExceptionDto {
        try {
            customerService.deleteCustomerById(request.getIdentityNo());
        } catch (BusinessException e) {
            ExceptionConverterUtil.throwDtoException(e);
        }
        return new DeleteCustomerByIdResponse();
    }

    @Override
    public FindCustomerResponse findCustomers(FindCustomerRequest request) {
        List<EContact> contacts = customerService.findCustomer(mapper.toEfContact(request.getCustomerFilterDto()));
        List<com.bank.api.dto.view.CustomerViewDto> customerViewDtos = contacts.stream().map(contact -> mapper.toCustomerViewDto(contact)).collect(Collectors.toList());
        return new FindCustomerResponse(customerViewDtos);

    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsExceptionDto, PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto, HolderExceptionDto, EntityAlreadyExistsExceptionDto {
        EContact contact = mapper.toEContact(request);
        try {
            customerService.updateCustomer(contact);
        } catch (BusinessException e) {
            ExceptionConverterUtil.throwDtoException(e);
        }
        return new UpdateCustomerResponse();
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsExceptionDto, PaymentApplicationTypeNotSupportCardWithoutHolderExceptionDto, HolderExceptionDto, EntityAlreadyExistsExceptionDto {
        EvCardIssueDetailData evCardIssueDetailData = null;
        try {
            evCardIssueDetailData = cardService.issueCard(mapper.toECard(request));
        } catch (BusinessException e) {
            ExceptionConverterUtil.throwDtoException(e);
        }
        return mapper.toIssueCardResponse(evCardIssueDetailData);
    }

    @Override
    public GetCardFullDetailsResponse getCardFullDetails(GetCardFullDetailsRequest request) {
        EvCard evCard = cardService.getCardFullDetails(request.getCardNo());
        CardViewDto viewDto = mapper.toCardViewDto(evCard);
         return new GetCardFullDetailsResponse(viewDto);
    }
}
