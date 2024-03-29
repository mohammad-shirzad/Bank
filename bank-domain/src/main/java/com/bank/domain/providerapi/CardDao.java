package com.bank.domain.providerapi;

import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.filter.EfCard;
import com.bank.domain.data.view.EvCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardDao extends JpaRepository<ECard, String> {
    @Query("select new com.bank.domain.data.view.EvCard(cc.firstName, cc.lastName, cc.identityNo, c.cardNo,c.CVV2, c.issueDate, c.expireDate, c.paymentApplicationType, c.paymentApplicationNumber, c.holderId, c.customerNo)" +
            "from ECard c left join  c.customer cc " +
            "where (cc.id is null or cc.id=:#{#filter.holderId}) and " +
            "(c.customerNo is null or c.customerNo=:#{#filter.CustomerNo}) and " +
            "(c.paymentApplicationType is null or c.paymentApplicationType=:#{#filter.paymentApplicationType}) and " +
            "(c.issueDate is null or c.issueDate=:#{#filter.issueDate}) and " +
            "(c.expireDate is null or c.expireDate=:#{#filter.expireDate})")
    public List<EvCard> findCardsByFilter(@Param("filter") EfCard efCard);

    @Query("select new com.bank.domain.data.view.EvCard(customer.firstName, customer.lastName, customer.identityNo, card.cardNo,card.CVV2, card.issueDate, card.expireDate, card.paymentApplicationType, card.paymentApplicationNumber, card.holderId, customer.customerNo)" +
            "from ECard card join card.customer customer where card.cardNo=:pan")
    EvCard getByPan(@Param("pan") String pan);
}
