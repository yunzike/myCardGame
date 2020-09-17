package entity;

import utils.CardNum;

/**
 * @author xiongxq
 * @Description Card
 * @date 2020/9/17 9:40 下午
 * version: 1.0
 */
public class Card {
    private String number;

    public Card(CardNum number) {
        this.number = number.getNumber();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (other.getNumber() == null) {
            return false;
        }
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }
}
