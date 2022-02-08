package ink.vor.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author muquanrui
 * @date 08/02/2022 22:02
 */
public class LeetCode0242 {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char c: s.toCharArray()) {
            map[c - 'a'] += 1;
        }
        for (char c: t.toCharArray()) {
            map[c - 'a'] -= 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
