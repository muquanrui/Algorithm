package ink.vor.sword2offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/25 16:05
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, !map.containsKey(ch));
        }
        for (Map.Entry<Character, Boolean> entry: map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
