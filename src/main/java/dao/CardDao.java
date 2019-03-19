package dao;

import entity.Card;

import java.util.List;
import java.util.Set;

public interface CardDao extends GenericDao<Card> {
    Set<Card> saveBatch(Set<Card> cards);

    List getCardsByCustomerId(int id);
}
