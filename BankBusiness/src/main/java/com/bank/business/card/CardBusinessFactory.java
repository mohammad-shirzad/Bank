package com.bank.business.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardBusinessFactory {
    private IssueCardBusiness issueCardBusiness;

    @Autowired
    public void setIssueCardBusiness(IssueCardBusiness issueCardBusiness) {
        this.issueCardBusiness = issueCardBusiness;
    }

    public IssueCardBusiness getIssueCardBusiness() {
        return issueCardBusiness;
    }
}
