package service;

import entity.Card;
import entity.Player;

import java.util.List;

/**
 * @author xiongxq
 * @Description CardGame
 * @date 2020/9/18 11:11 下午
 * version: 1.0
 */
public interface DotGame {

    List<Player> initPlayer(int count);

    void start(List<Card> cardsList, List<Player> players);


}
