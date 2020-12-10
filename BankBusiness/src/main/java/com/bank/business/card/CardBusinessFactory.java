package com.bank.business.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardBusinessFactory {
    private IssueCardBusiness issueCardBusiness;
    private GetCardFullDetailsBusiness getCardFullDetailsBusiness;

    @Autowired
    public void setIssueCardBusiness(IssueCardBusiness issueCardBusiness, GetCardFullDetailsBusiness getCardFullDetailsBusiness) {
        this.issueCardBusiness = issueCardBusiness;
        this.getCardFullDetailsBusiness = getCardFullDetailsBusiness;
    }

    public IssueCardBusiness getIssueCardBusiness() {
        return issueCardBusiness;
    }

    public GetCardFullDetailsBusiness getGetCardFullDetailsBusiness() {
        return getCardFullDetailsBusiness;
    }
}
