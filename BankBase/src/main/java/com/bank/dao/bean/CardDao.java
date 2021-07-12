package com.bank.dao.bean;

import com.bank.data.entity.ECard;
import com.bank.data.filter.EfCard;
import com.bank.data.view.EvCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardDao extends ExtendedRepository<ECard, String> {
    @Query("select new com.bank.data.view.EvCard(cc.firstName, cc.lastName, cc.identityNo, c.cardNo,c.CVV2, c.issueDate, c.expireDate, c.paymentApplicationType, c.paymentApplicationNumber, c.holderId, c.ownerCustomerNo)" +
            "from ECard c left join  c.customer cc " +
            "where (cc.id is null or cc.id=:#{#filter.holderId}) and " +
            "(c.ownerCustomerNo is null or c.ownerCustomerNo=:#{#filter.ownerCustomerNo}) and " +
            "(c.paymentApplicationType is null or c.paymentApplicationType=:#{#filter.paymentApplicationType}) and " +
            "(c.issueDate is null or c.issueDate=:#{#filter.issueDate}) and " +
            "(c.expireDate is null or c.expireDate=:#{#filter.expireDate})")
    public List<EvCard> findCardsByFilter(@Param("filter") EfCard efCard);

    @Query("select new com.bank.data.view.EvCard(customer.firstName, customer.lastName, customer.identityNo, card.cardNo,card.CVV2, card.issueDate, card.expireDate, card.paymentApplicationType, card.paymentApplicationNumber, card.holderId, customer.customerNo)" +
            "from ECard card join card.customer customer where card.cardNo=:pan")
    EvCard getByPan(@Param("pan") String pan);
}
