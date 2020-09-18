package service;

import entity.Card;
import entity.Player;

import java.util.List;

/**
 * @author xiongxq
 * @Description service.CardManager
 * @date 2020/9/18 11:05 下午
 * version: 1.0
 */
public interface CardManager {

    List<Card> createCardsList();

    void mixCardsList(List<Card> cardsList);

    void dealCards(List<Card> cardsList, List<Player> plays);

    Card playCard(Player player, int index);

}
