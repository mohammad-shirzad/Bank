package com.bank.domain.business.card;

import com.bank.domain.business.utility.GeneratorUtil;
import com.bank.domain.business.utility.ObjectMapper;
import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.domain.data.filter.EfContact;
import com.bank.domain.data.view.EvCardIssueDetailData;
import com.bank.domain.providerapi.CardDao;
import com.bank.domain.providerapi.ContactDao;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class IssueCardBusiness {

    private final CardDao cardDao;
    private final ContactDao contactDao;
    private EContact customer;
    private final ObjectMapper mapper = ObjectMapper.INSTANCE;

    public IssueCardBusiness(CardDao cardDao, ContactDao contactDao) {
        this.cardDao = cardDao;
        this.contactDao = contactDao;
    }

    public void validate(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        EfContact efContact = new EfContact();
        efContact.setCustomerNo(card.getCustomerNo());
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
        card.setCardNo(GeneratorUtil.generateCardNo("saman"));
        card.setCVV2(GeneratorUtil.generateCVV2());
        card.setFirstPin(GeneratorUtil.generatePin1());
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
