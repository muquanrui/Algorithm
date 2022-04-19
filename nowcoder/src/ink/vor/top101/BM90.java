package ink.vor.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/19 22:44
 */
public class BM90 {
    public String minWindow (String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int[] res = new int[3];
        res[2] = Integer.MAX_VALUE;
        int left = 0;
        int countValidChar = 0;
        for (int right = 0; right < S.length(); right++) {
            char ch = S.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) >= 0) {
                countValidChar++;
            }
            while (countValidChar == T.length()) {
                if (right - left + 1 < res[2]) {
                    res[0] = left;
                    res[1] = right + 1;
                    res[2] = right - left + 1;
                }
                char lChar = S.charAt(left++);
                map.put(lChar, map.get(lChar) + 1);
                if (map.get(lChar) > 0) {
                    countValidChar--;
                }
            }
        }
        return res[2] == Integer.MAX_VALUE ? "" : S.substring(res[0], res[1]);
    }
}
