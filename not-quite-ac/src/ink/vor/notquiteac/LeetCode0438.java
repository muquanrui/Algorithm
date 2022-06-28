package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/28 19:14
 */
public class LeetCode0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] dict = new int[26];
        for (char ch : p.toCharArray()) {
            dict[ch - 'a']++;
        }
        List<Integer> resList = new ArrayList<>();
        int start = 0;
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            dict[s.charAt(end) - 'a']--;
            if (dict[s.charAt(end) - 'a'] >= 0) {
                count++;
            }
            while (count == p.length()) {
                if (end - start + 1 == p.length()) {
                    resList.add(start);
                }
                dict[s.charAt(start) - 'a']++;
                if (dict[s.charAt(start) - 'a'] > 0) {
                    count--;
                }
                start++;
            }
        }
        return resList;
    }
}
