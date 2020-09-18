package service.impl;

import entity.Card;
import entity.CardNum;
import entity.CardType;
import entity.Player;
import service.CardManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiongxq
 * @Description PokerManager
 * @date 2020/9/18 11:40 下午
 * version: 1.0
 */
public class DotCardManager implements CardManager {

    //创建牌
    public List<Card> createCardsList() {
        List<Card> cardsList = new ArrayList<>();
        for (CardType value : CardType.values()) {
            for (CardNum e : CardNum.values()) {
                Card card = new Card(e, value);
                cardsList.add(card);
            }
        }
        Collections.sort(cardsList);
        return cardsList;
    }

    public void mixCardsList(List<Card> cardsList) {
        Collections.shuffle(cardsList);
    }

    //发牌
    public void dealCards(List<Card> cardsList, List<Player> plays) {
        for (int i = 0; i < plays.size(); i++) {
            List<Card> list = new ArrayList<>();
            for (int j = i; j < cardsList.size(); j += plays.size()) {
                list.add(cardsList.get(j));
            }
            plays.get(i).setCards(list);
        }
    }

    public void outputPlayerCards(Player play) {
        Collections.sort(play.getCards());
        System.out.println("玩家 " + play.getName() + "，您好，您手中的牌共有" + play.getCards().size() + "张，分别为:");
        System.out.println(play.getCards());
    }

    //出牌
    public Card playCard(Player player, int index) {
        return player.getCards().remove(index);
    }



}
