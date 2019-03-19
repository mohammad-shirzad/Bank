package service;

import entity.Card;

import java.util.List;
import java.util.Set;

public interface CardService {
    Card saveCard(Card card);

    Set<Card> saveCards(Set<Card> cards);

    List<Card> getCardsByCustomerId(int cid);
}
