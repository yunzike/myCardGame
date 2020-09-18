import entity.Card;
import entity.CardNum;
import entity.CardType;
import org.junit.Assert;
import org.junit.Test;
import service.WinStrategy;
import service.impl.DotWin;

import java.util.ArrayList;
import java.util.List;


public class WinStrategyTest {

    @Test
    public void createCardsListTest(){
        WinStrategy strategy = new DotWin();

        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(CardNum.ACE, CardType.CLUBS);
        cards.add(card1);
        Card card2 = new Card(CardNum.THREE, CardType.CLUBS);
        cards.add(card2);
        Card card3 = new Card(CardNum.DEUCE, CardType.DIAMONDS);
        cards.add(card3);

        int maxIndex = strategy.action(cards);

        Assert.assertEquals(2, maxIndex);

    }


}
