package com.bank.business.card;

import com.bank.business.utility.GeneratorUtil;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.ContactDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.enums.PaymentApplicationType;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.filter.EfContact;
import com.common.utils.parser.BankConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
@Scope(value = "prototype")
public class IssueCardBusiness {

    private CardDao cardDao;
    private ContactDao contactDao;
    private EContact customer;

    @Autowired
    IssueCardBusiness(DaoFactory daoFactory) {
        this.cardDao = daoFactory.getCardDao();
        this.contactDao = daoFactory.getContactDao();
    }

    public void validate(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EfContact efContact = new EfContact();
        efContact.setCustomerNo(card.getOwnerCustomerNo());
        efContact.setHolderId(card.getHolderId());
        List<EContact> dbCustomers = contactDao.find(efContact);
        if (dbCustomers.isEmpty())
            throw new EntityNotExistsException("There is no contact with provided identity");
        customer = dbCustomers.get(0);
        if (!CardBusiness.supportNoName(card.getPaymentApplicationType()) && card.getHolderId() == null) {
            throw new PaymentApplicationTypeNotSupportCardWithoutHolderException("Only bonus and gift cards can be issued without holder");
        }

    }

    public ECard doBusiness(ECard card) {
        card.setCustomer(customer);
        card.setPan(GeneratorUtil.generateCardNo(BankConfigProvider.getInstance().getBankName()));
        card.setCVV2(GeneratorUtil.generateCVV2());
        card.setPin1(GeneratorUtil.generatePin1());
        card.setIssueDate(Calendar.getInstance().getTime());
        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.add(Calendar.MONTH, 6);
        card.setExpireDate(currentDateTime.getTime());
        return cardDao.save(card);
    }

    public ECard execute(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        validate(card);
        return doBusiness(card);
    }
}
