package ink.vor.notquiteac;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/3 16:15
 */

// https://leetcode.cn/problems/minimum-window-substring/
public class LeetCode0076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int resLength = Integer.MAX_VALUE;
        int resLeft = -1;
        int resRight = -1;
        int countStr = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) >= 0) {
                countStr++;
            }
            while (countStr == t.length()) {
                if (right - left + 1 < resLength) {
                    resLength = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }
                char tmp = s.charAt(left++);
                map.put(tmp, map.get(tmp) + 1);
                if (map.get(tmp) > 0) {
                    countStr--;
                }
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
}
