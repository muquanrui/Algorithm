package ink.vor.sword2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/25 16:05
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.get(ch) != null) {
                left = Math.max(left, map.get(ch));
            }
            map.put(ch, right);
            res = Math.max(res, right - left);
        }
        return res;
    }
}
