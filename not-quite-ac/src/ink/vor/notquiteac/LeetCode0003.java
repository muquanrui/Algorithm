package ink.vor.notquiteac;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/5/29 10:43
 */

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class LeetCode0003 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            res = Math.max(res, set.size());
            set.remove(s.charAt(left));
            left++;
        }
        return res;
    }
}
