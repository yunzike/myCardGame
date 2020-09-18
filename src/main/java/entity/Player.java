package entity;

import java.util.List;

/**
 * @author xiongxq
 * @Description Player
 * @date 2020/9/17 9:45 下午
 * version: 1.0
 */
public class Player {

    private String name;
    private List<Card> cards;
    private Integer score;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
