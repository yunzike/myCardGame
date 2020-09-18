import entity.Player;
import org.junit.Test;
import service.DotGame;
import service.impl.DotCardGame;

import java.util.List;


public class DotMyCardGameTest {

    private DotGame game = new DotCardGame();
    private List<Player> players = null;

    @Test
    public void initPlayerTest() {
        players = game.initPlayer(2);

        players.forEach((item) -> {
            System.out.println(item.getName() + "  :牌：" + item.getCards() + ",分数：" + item.getScore());
        });

    }

}
