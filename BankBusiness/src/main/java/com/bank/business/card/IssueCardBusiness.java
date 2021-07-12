package com.bank.business.card;

import com.bank.business.utility.GeneratorUtil;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.ContactDao;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EvCardIssueDetailData;
import com.common.utils.parser.BankConfigProvider;
import com.common.utils.singleton.DozerMapper;

import java.util.Calendar;
import java.util.List;

public class IssueCardBusiness {

    private CardDao cardDao;
    private ContactDao contactDao;
    private EContact customer;

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
        return DozerMapper.getDozerBeanMapper().map(card, EvCardIssueDetailData.class);
    }

    public EvCardIssueDetailData execute(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        validate(card);
        return doBusiness(card);
    }
}
