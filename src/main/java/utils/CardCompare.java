package utils;

import entity.Card;

import java.util.Comparator;

/**
 * @author xiongxq
 * @Description Compara
 * @date 2020/9/17 10:10 下午
 * version: 1.0
 */
public class CardCompare implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        String numbers = "3 4 5 6 7 8 9 10 J Q K A 2";

        int result = numbers.indexOf(c1.getNumber()) - numbers.indexOf(c2.getNumber());

        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
