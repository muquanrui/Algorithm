package ink.vor.daily;

import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/12/23 01:45
 */

public class LeetCode2011 {
    public int finalValueAfterOperations(String[] operations) {
        int[] map = new int[2];
        for (String op : operations) {
            if ("++X".equals(op) || "X++".equals(op)) {
                map[0]++;
            } else {
                map[1]++;
            }
        }
        return map[0] - map[1];
    }
}
