package com.bank.business.factory;

import com.bank.business.card.GetCardFullDetailsBusiness;
import com.bank.business.card.IssueCardBusiness;
import com.bank.business.customer.DeleteCustomerBusiness;
import com.bank.business.customer.FindCustomersBusiness;
import com.bank.business.customer.RegisterCustomerBusiness;
import com.bank.business.customer.UpdateCustomerBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessFactory {
    private static IssueCardBusiness issueCardBusiness;
    private static GetCardFullDetailsBusiness getCardFullDetailsBusiness;
    private static RegisterCustomerBusiness registerCustomerBusiness;
    private static UpdateCustomerBusiness updateCustomerBusiness;
    private static FindCustomersBusiness findCustomersBusiness;
    private static DeleteCustomerBusiness deleteCustomerBusiness;

    @Autowired
    public void setIssueCardBusiness(IssueCardBusiness issueCardBusiness) {
        this.issueCardBusiness = issueCardBusiness;
    }

    @Autowired
    public void setGetCardFullDetailsBusiness(GetCardFullDetailsBusiness getCardFullDetailsBusiness) {
        this.getCardFullDetailsBusiness = getCardFullDetailsBusiness;
    }

    @Autowired
    public void setRegisterCustomerBusiness(RegisterCustomerBusiness registerCustomerBusiness) {
        this.registerCustomerBusiness = registerCustomerBusiness;
    }

    @Autowired
    public void setUpdateCustomerBusiness(UpdateCustomerBusiness updateCustomerBusiness) {
        this.updateCustomerBusiness = updateCustomerBusiness;
    }

    @Autowired
    public void setFindCustomersBusiness(FindCustomersBusiness findCustomersBusiness) {
        this.findCustomersBusiness = findCustomersBusiness;
    }

    @Autowired
    public void setDeleteCustomerBusiness(DeleteCustomerBusiness deleteCustomerBusiness) {
        this.deleteCustomerBusiness = deleteCustomerBusiness;
    }


    public static IssueCardBusiness getIssueCardBusiness() {
        return issueCardBusiness;
    }

    public static GetCardFullDetailsBusiness getGetCardFullDetailsBusiness() {
        return getCardFullDetailsBusiness;
    }

    public static DeleteCustomerBusiness getDeleteCustomerBusiness() {
        return deleteCustomerBusiness;
    }

    public static FindCustomersBusiness getFindCustomersBusiness() {
        return findCustomersBusiness;
    }

    public static UpdateCustomerBusiness getUpdateCustomerBusiness() {
        return updateCustomerBusiness;
    }


    public static RegisterCustomerBusiness getRegisterCustomerBusiness() {
        return registerCustomerBusiness;
    }
}
