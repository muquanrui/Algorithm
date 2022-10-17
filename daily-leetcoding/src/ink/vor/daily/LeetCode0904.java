package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/10/17 12:54
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/fruit-into-baskets/
 */
public class LeetCode0904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < fruits.length; right++) {
            if (!map.containsKey(fruits[right]) && map.size() == 2) {
                int removeI = -1;
                for (int n : map.keySet()) {
                    if (n != fruits[right - 1]) {
                        removeI = n;
                        break;
                    }
                }
                left = map.remove(removeI) + 1;
            }
            map.put(fruits[right], right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
