package service;

import entity.Card;

import java.util.List;

/**
 * @author xiongxq
 * @Description WinStrategy
 * @date 2020/9/18 11:04 下午
 * version: 1.0
 */
public interface WinStrategy {

    int action(List<Card> cards);

}
