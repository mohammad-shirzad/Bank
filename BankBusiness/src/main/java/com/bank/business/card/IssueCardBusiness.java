package com.bank.business.card;

import com.bank.business.utility.GeneratorUtil;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECard;
import com.bank.data.entity.ECustomer;
import com.bank.data.enums.PaymentApplicationType;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.filter.EfCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@Component
public class IssueCardBusiness {

    private CardDao cardDao;
    private CustomerDao customerDao;
    private ECustomer customer;

    @Autowired
    IssueCardBusiness(DaoFactory daoFactory) {
        this.cardDao = daoFactory.getCardDao();
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void validate(ECard card) throws EntityAlreadyExistsException, EntityNotExistsException, HolderException, SQLException {
        List<ECard> cards = cardDao.find(card);
        if (!cards.isEmpty())
            throw new EntityAlreadyExistsException("card no " + cards.get(0).getPan() + " on account " +
                    cards.get(0).getPaymentApplicationNumber() + " has issued before");
        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setCustomerNo(card.getOwnerCustomerNo());
        List<ECustomer> dbCustomers = customerDao.find(efCustomer);
        if (dbCustomers.isEmpty())
            throw new EntityNotExistsException("there is no customer with customerNo " + card.getOwnerCustomerNo());
        customer = dbCustomers.get(0);
        if ((card.getPaymentApplicationType() == PaymentApplicationType.Bonus ||
                card.getPaymentApplicationType() == PaymentApplicationType.Gift) &&
                card.getHolderId() != null) {
            throw new HolderException("For special cards, holder must be null");
        }
        if ((card.getPaymentApplicationType() == PaymentApplicationType.Debit ||
                card.getPaymentApplicationType() == PaymentApplicationType.Deposit ||
                card.getPaymentApplicationType() == PaymentApplicationType.Loan ||
                card.getPaymentApplicationType() == PaymentApplicationType.Corporation ||
                card.getPaymentApplicationType() == PaymentApplicationType.Credit) &&
                (card.getHolderId() == null)) {
            throw new HolderException("Holder can not be null");
        }

    }

    public ECard doBusiness(ECard card) {
        card.setLastModificationDate(Calendar.getInstance().getTime());
        card.setCustomer(customer);
        card.setPan(GeneratorUtil.generateCardNo());
        card.setCVV2(GeneratorUtil.generateCVV2());
        card.setPin1("1234");
        card.setIssueDate(Calendar.getInstance().getTime());
        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.add(Calendar.MONTH, 6);
        card.setExpireDate(currentDateTime.getTime());
        return cardDao.save(card);
    }

    public ECard execute(ECard card) throws EntityAlreadyExistsException, EntityNotExistsException, HolderException, SQLException {
        validate(card);
        return doBusiness(card);
    }
}
