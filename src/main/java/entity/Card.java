package entity;

/**
 * @author xiongxq
 * @Description Card
 * @date 2020/9/17 9:40 下午
 * version: 1.0
 */
public class Card implements Comparable<Card> {
    private String number;
    private CardType cardType;

    public Card(CardNum number,CardType cardType) {
        this.number = number.getNumber();
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public CardType getCardType() {
        return cardType;
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
            return other.number == null;
        } else return number.equals(other.number);
    }

    @Override
    public int compareTo(Card other) {
        String numbers = "3 4 5 6 7 8 9 10 J Q K A 2";

        int result = numbers.indexOf(this.getNumber()) - numbers.indexOf(other.getNumber());

        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            if (this.cardType.getId() < other.cardType.getId()) {
                return -1;
            } else if (this.cardType.getId() > other.cardType.getId()) {
                return 1;
            }
            return 0;
        }
    }
}
