package daoImpl;

import dao.CardDao;
import entity.Card;

import java.util.List;
import java.util.Set;

public class CardDaoImpl extends AbstractJpaDao<Card> implements CardDao {

    @Override
    public Set<Card> saveBatch(Set<Card> cards) {
        for (Card card : cards
                ) {
            getEntityManager().persist(card);
        }
        return cards;
    }

    @Override
    public List<Card> getCardsByCustomerId(int cid) {
        return getEntityManager().createQuery("from card where customer.id=:id"
                , Card.class).setParameter("id", cid).getResultList();
    }
}
