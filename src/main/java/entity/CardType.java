package entity;

/**
 * @author xiongxq
 * @Description CardType
 * @date 2020/9/18 10:57 下午
 * version: 1.0
 */
public enum CardType {

    SPADES("♠", 4),
    HEARTS("♥", 3),
    CLUBS("♣", 2),
    DIAMONDS("♦", 1);

    private String pic;
    private int id;

    CardType(String pic, int id){
        this.pic = pic;
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public int getId() {
        return id;
    }
}
