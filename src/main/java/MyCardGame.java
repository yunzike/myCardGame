import entity.Card;
import entity.Player;
import service.impl.DotCardManager;
import service.impl.DotCardGame;
import utils.ConsoleUtils;

import java.util.*;

/**
 * @author xiongxq
 * @Description Compara
 * @date 2020/9/17 10:20 下午
 * version: 1.0
 */
public class MyCardGame {
    public static void main(String[] args) {
        ConsoleUtils.showText(true, true, "欢迎进入CardGame");
        ConsoleUtils.showText(false, false, "请输入参与人数：");
        int count = ConsoleUtils.getInput();

        DotCardGame game = new DotCardGame();
        List<Player> players = game.initPlayer(count);

        DotCardManager cardManager = new DotCardManager();
        List<Card> cardsList = cardManager.createCardsList();

        while (true) {//开始游戏
            cardManager.mixCardsList(cardsList);
            game.start(cardsList, players);
            ConsoleUtils.showText(true, true, "是否继续游游戏？请输入按键选择：1：再来一局；0：退出游戏");
            int option = ConsoleUtils.getInput();
            if (option == 0){
                break;
            }
        }

    }
}
