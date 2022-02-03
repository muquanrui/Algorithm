package ink.vor.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 03/02/2022 22:42
 */
public class LeetCode0076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int countChar = 0;
        int targetChar = t.length();
        int resLength = Integer.MAX_VALUE;
        int resLeft = -1;
        int resRight = -1;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) >= 0) {
                countChar++;
            }
            while (countChar == targetChar) {
                if (right - left + 1 < resLength) {
                    resLeft = left;
                    resRight = right + 1;
                    resLength = resRight - resLeft;
                }
                c = s.charAt(left);
                map.put(c, map.get(c) + 1);
                if (map.get(c) > 0) {
                    countChar--;
                }
                left++;
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight);
    }
}
