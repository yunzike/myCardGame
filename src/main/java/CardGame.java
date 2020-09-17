import entity.Card;
import entity.Player;
import utils.CardCompare;
import utils.CardNum;

import java.util.*;

/**
 * @author xiongxq
 * @Description Compara
 * @date 2020/9/17 10:20 下午
 * version: 1.0
 */
public class CardGame {

    private static Scanner in = new Scanner(System.in);
    private static List<Card> cardsList = new ArrayList<>();
    private static Player playA;
    private static Player playB;

    public static void start() {
        CardGame game = new CardGame();
        game.createCardsList();

        System.out.println("\n****************游戏开始******************");

        System.out.println("玩家 A ，您好！请输入你的昵称:");
        String nameA = in.next();
        playA = game.getPlayer(nameA, 1);

        System.out.println("玩家 B ，您好！请输入你的昵称:");
        String nameB = in.next();
        playB = game.getPlayer(nameB, 2);

        Map<String, CardNum> cardsMap = new HashMap<>();
        for (CardNum value : CardNum.values()) {
            cardsMap.put(value.getNumber(), value);
        }

        Card card1 = null, card2 = null;
        for (int i = 0; i < cardsList.size(); i++) {
            if (i % 2 == 0) {
                System.out.println();
                card1 = getCard(cardsMap, playA);
                if (card1 == null) {
                    i--;
                    continue;
                }
            } else {
                card2 = getCard(cardsMap, playB);
                if (card2 == null) {
                    i--;
                    continue;
                }
                CardCompare compare = new CardCompare();
                int result = compare.compare(card1, card2);
                if (result == 0) {
                    System.out.println("玩家" + playA.getName() + "、" + "玩家" + playB.getName() + "出牌大小相同，各积 1 分！");
                    playA.setScore(playA.getScore() + 1);
                    playB.setScore(playB.getScore() + 1);
                } else if (result > 0) {
                    System.out.println("玩家" + playA.getName() + "出牌比" + "玩家" + playB.getName() + "更大," + "玩家" + playA.getName() + "赢得 1 分！");
                    playA.setScore(playA.getScore() + 1);
                } else {
                    System.out.println("玩家" + playB.getName() + "出牌比" + "玩家" + playA.getName() + "更大," + "玩家" + playB.getName() + "赢得 1 分！");
                    playB.setScore(playB.getScore() + 1);
                }
                System.out.println("目前比分：" + playA.getScore() + ":" + playB.getScore() + "\n");
                card1 = null;
                card2 = null;
            }
        }
        System.out.println("\n****************游戏结束******************");
        System.out.println("玩家" + playA.getName() + "共计得分：" + playA.getScore());
        System.out.println("玩家" + playB.getName() + "共计得分：" + playB.getScore());
        if (playA.getScore() > playB.getScore()) {
            System.out.println("本轮游戏最终获胜玩家为：" + playA.getName());
        } else if (playA.getScore() < playB.getScore()) {
            System.out.println("本轮游戏最终获胜玩家为：" + playA.getName());
        } else {
            System.out.println("本轮游戏最终为平局！");
        }

    }

    /**
     * 从控制台获取出牌并校验
     *
     * @param cardsMap
     * @param play
     * @return
     */
    private static Card getCard(Map<String, CardNum> cardsMap, Player play) {
        System.out.println("玩家" + play.getName() + "请出牌：" + play.getCards() + " 剩余牌的数量：" + play.getCards().size());
        String cardName = in.next();
        Card card = null;
        if (!cardsMap.containsKey(cardName) || !play.getCards().contains(new Card(cardsMap.get(cardName)))) {
            System.out.println("出牌错误，您只能出您手中剩余的牌！");
        } else {
            card = new Card(cardsMap.get(cardName));
            play.getCards().remove(card);
        }
        return card;
    }

    /**
     * 创建扑克牌
     *
     * @return
     */
    public List<Card> createCardsList() {
        for (int i = 0; i < 4; i++) {
            for (CardNum e : CardNum.values()) {
                Card card = new Card(e);
                cardsList.add(card);
            }
        }
        System.out.println("生成扑克牌：");
        Collections.sort(cardsList, new CardCompare());
        System.out.println(cardsList);

        mixCardsList();
        System.out.println("洗牌后：");
        System.out.println(cardsList);

        return cardsList;
    }

    /**
     * 洗牌
     */
    private void mixCardsList() {
        Collections.shuffle(cardsList);
    }

    /**
     * 创建玩家
     */
    public Player getPlayer(String name, int n) {
        Player play = new Player(name);
        play.setCards(getCards(n));
        play.setScore(0);

        outputPlayerCards(play);
        return play;
    }

    /**
     * 发牌
     *
     * @param n
     * @return
     */
    private List<Card> getCards(int n) {
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < cardsList.size() / 2; i++) {
            list.add(cardsList.get(n - 1));
            n += 2;
        }
        return list;
    }

    /**
     * 显示玩家拿到的牌
     *
     * @param play
     */
    private void outputPlayerCards(Player play) {
        Collections.sort(play.getCards(), new CardCompare());
        System.out.println("玩家 " + play.getName() + "，您好，您手中的牌共有" + play.getCards().size() + "张，分别为:");
        System.out.println(play.getCards());
    }

}
