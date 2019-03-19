package serviceImpl;

import dao.CardDao;
import entity.Card;
import service.CardService;

import java.util.List;
import java.util.Set;

public class CardServiceImpl implements CardService {
    private CardDao cardDao;

    public void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public Card saveCard(Card card) {
        cardDao.create(card);
        return card;
    }

    @Override
    public Set<Card> saveCards(Set<Card> cards) {
        return cardDao.saveBatch(cards);
    }

    @Override
    public List<Card> getCardsByCustomerId(int cid) {
        return cardDao.getCardsByCustomerId(cid);
    }

}
