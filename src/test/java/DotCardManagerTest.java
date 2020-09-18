import entity.Card;
import org.junit.Assert;
import org.junit.Test;
import service.impl.DotCardManager;

import java.util.List;


public class DotCardManagerTest {

    private final DotCardManager cardmanager = new DotCardManager();

    @Test
    public void createCardsListTest(){
        List<Card> cardsList = cardmanager.createCardsList();
        System.out.println(cardsList);
        Assert.assertEquals(52, cardsList.size());
    }

}
