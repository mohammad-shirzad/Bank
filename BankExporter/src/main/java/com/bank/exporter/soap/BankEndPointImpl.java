package com.bank.exporter.soap;

import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EvCard;
import com.bank.data.view.EvCardIssueDetailData;
import com.bank.exporter.dto.view.CardViewDto;
import com.bank.exporter.dto.view.CustomerViewDto;
import com.bank.exporter.request.*;
import com.bank.exporter.response.*;
import com.bank.service.CardService;
import com.bank.service.CustomerService;
import com.common.utils.singleton.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "BankSOAPEndpoint")
@WebService(endpointInterface = "com.bank.exporter.soap.BankEndPoint")
public class BankEndPointImpl implements BankEndPoint {

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
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException {
        EContact contact = DozerMapper.getDozerBeanMapper().map(request, EContact.class);
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
        List<EContact> contacts = customerService.findCustomer(DozerMapper.getDozerBeanMapper().map(request.getCustomerFilterDto(), EfContact.class));
        List<CustomerViewDto> customerViewDtos = contacts.stream().map(contact->DozerMapper.getDozerBeanMapper().map(contacts, CustomerViewDto.class)).collect(Collectors.toList());
        return new FindCustomerResponse(customerViewDtos);

    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException {
        EContact contact = DozerMapper.getDozerBeanMapper().map(request, EContact.class);
        customerService.updateCustomer(contact);
        return new UpdateCustomerResponse();
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EvCardIssueDetailData evCardIssueDetailData = cardService.issueCard(DozerMapper.getDozerBeanMapper().map(request, ECard.class));
        return DozerMapper.getDozerBeanMapper().map(evCardIssueDetailData, IssueCardResponse.class);
    }

    @Override
    public GetCardFullDetailsResponse getCardFullDetails(GetCardFullDetailsRequest request) {
         EvCard evCard = cardService.getCardFullDetails(request.getCardNo());
         CardViewDto viewDto = DozerMapper.getDozerBeanMapper().map(evCard, CardViewDto.class);
         return new GetCardFullDetailsResponse(viewDto);
    }
}
