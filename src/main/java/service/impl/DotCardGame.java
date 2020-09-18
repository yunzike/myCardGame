package service.impl;

import entity.Card;
import entity.Player;
import service.DotGame;
import service.WinStrategy;
import utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiongxq
 * @Description DotCardGame
 * @date 2020/9/18 11:13 下午
 * version: 1.0
 */
public class DotCardGame implements DotGame {

    @Override
    public List<Player> initPlayer(int count) {
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ConsoleUtils.showText(false, true, "请输入第" + i + "号玩家的昵称：");
            String name = ConsoleUtils.getInputString();
            Player player = new Player(name);
            list.add(player);
        }
        return list;
    }

    @Override
    public void start(List<Card> cardsList, List<Player> players) {

        //发牌
        DotCardManager cardManager = new DotCardManager();
        cardManager.dealCards(cardsList, players);
        for (Player player : players) {
            cardManager.outputPlayerCards(player);
        }

        //出牌
        WinStrategy winStrategy = new DotWin();
        int size = Integer.MAX_VALUE;
        for (Player player : players) {
            if (player.getCards().size() < size) {
                size = player.getCards().size();
            }
        }
        for (int i = 0; i < size; i++) {
            List<Card> cards = new ArrayList<>();
            for (Player player : players) {
                Card card = cardManager.playCard(player, 0);//出牌
                cards.add(card);
            }
            int result = winStrategy.action(cards);
            if (result == -1) {
                for (Player player : players) {
                    player.setScore(player.getScore() == null ? 1 : player.getScore() + 1);
                }
            } else {
                Player winner = players.get(result);
                if (winner.getScore()==null) {
                    winner.setScore(0);
                }
                winner.setScore(winner.getScore() + 1);
            }
        }

        //游戏结束
        ConsoleUtils.showText(false, true, "游戏结束，比分结果如下：");

        StringBuilder scores = new StringBuilder(players.get(0).getName() + "[" + players.get(0).getScore() + "]");
        players.get(0).setCards(null);
        players.get(0).setScore(null);
        for (int i = 1; i < players.size(); i++) {
            scores.append(" : ").append(players.get(i).getName()).append("[").append(+players.get(i).getScore()).append("]");
            players.get(i).setCards(null);
            players.get(i).setScore(null);
        }

        ConsoleUtils.showText(false, true, scores.toString());

    }

}
