package service.impl;

import entity.Card;
import service.WinStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiongxq
 * @Description DotWinStrategy
 * @date 2020/9/18 11:06 下午
 * version: 1.0
 */
public class DotWin implements WinStrategy {

    public int action(List<Card> cards) {
        String numbers = "3 4 5 6 7 8 9 10 J Q K A 2";

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            map.put(numbers.indexOf(cards.get(i).getNumber()), i);
        }
        if (map.size() == 1) {//所有玩家出牌相同
            return -1;
        } else {//返回出牌最大玩家的index
            int min = Integer.MIN_VALUE;
            int index = 0;
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : set) {
                Integer key = entry.getKey();
                if (key > min) {
                    min = key;
                    index = entry.getValue();
                }
            }
            return index;
        }

    }

}
