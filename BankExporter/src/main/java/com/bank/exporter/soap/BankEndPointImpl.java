package com.bank.exporter.soap;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.facade.facade.BankFacade;
import com.bank.facade.request.*;
import com.bank.facade.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;

@Component(value = "BankSOAPEndpoint")
@WebService(endpointInterface = "com.bank.exporter.soap.BankEndPoint")
public class BankEndPointImpl implements BankEndPoint {


    private BankFacade bankFacade;

    @Autowired
    @WebMethod(exclude = true)
    public void setBankFacade(BankFacade bankFacade) {
        this.bankFacade = bankFacade;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException {
        return bankFacade.createNewCustomer(request);
    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomer(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException {
        return bankFacade.deleteCustomerById(request);
    }

    @Override
    public FindCustomerResponse findCustomers(FindCustomerRequest request) throws SQLException {
        return bankFacade.findCustomer(request);
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException, SQLException {
        return bankFacade.updateCustomer(request);
    }

    @Override
    public IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException {
        return bankFacade.issueCard(request);
    }
}
