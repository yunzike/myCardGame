package utils;

/**
 * @author xiongxq
 * @Description CardNum
 * @date 2020/9/17 10:05 下午
 * version: 1.0
 */
public enum CardNum {

    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A"),
    DEUCE("2");

    private String number;

    CardNum(String number){
      this.number = number;
    };

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }

}
