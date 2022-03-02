package com.bank.business.business.card;

import com.bank.business.business.utility.GeneratorUtil;
import com.bank.dao.repository.CardDao;
import com.bank.dao.repository.ContactDao;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EvCardIssueDetailData;
import com.bank.util.ObjectMapper;
import com.bank.util.parser.BankConfigProvider;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class IssueCardBusiness {

    private CardDao cardDao;
    private ContactDao contactDao;
    private EContact customer;
    private ObjectMapper mapper = ObjectMapper.INSTANCE;

    public IssueCardBusiness(CardDao cardDao, ContactDao contactDao) {
        this.cardDao = cardDao;
        this.contactDao = contactDao;
    }

    public void validate(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EfContact efContact = new EfContact();
        efContact.setCustomerNo(card.getOwnerCustomerNo());
        efContact.setHolderId(card.getHolderId());
        List<EContact> dbCustomers = contactDao.findByFilter(efContact);
        if (dbCustomers.isEmpty())
            throw new EntityNotExistsException("There is no contact with provided identity");
        customer = dbCustomers.get(0);
        if (!CardBusiness.supportNoName(card.getPaymentApplicationType()) && card.getHolderId() == null) {
            throw new PaymentApplicationTypeNotSupportCardWithoutHolderException("Only bonus and gift cards can be issued without holder");
        }

    }

    public EvCardIssueDetailData doBusiness(ECard card) {
        card.setCustomer(customer);
        card.setCardNo(GeneratorUtil.generateCardNo(BankConfigProvider.getInstance().getBankName()));
        card.setCVV2(GeneratorUtil.generateCVV2());
        card.setPin1(GeneratorUtil.generatePin1());
        card.setIssueDate(Calendar.getInstance().getTime());
        card.setPaymentApplicationType(card.getPaymentApplicationType());
        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.add(Calendar.MONTH, 6);
        card.setExpireDate(currentDateTime.getTime());
        card = cardDao.save(card);
        return mapper.toEvCardIssueDetailData(card);
    }

    public EvCardIssueDetailData execute(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        validate(card);
        return doBusiness(card);
    }
}
