package ink.vor.top100liked;

import java.util.HashMap;

/**
 * @author muquanrui
 * @date 26/11/2021 10:34
 */
public class LeetCode0003 {
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0;
        while (start < s.length() - maxLength) {
            while (end < s.length() && (map.get(s.charAt(end)) == null || map.get(s.charAt(end)) < start)) {
                map.put(s.charAt(end), end);
                end++;
            }
            maxLength = Math.max(maxLength, end - start);
            if (end < s.length()) {
                start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end), end);
                end++;
            }
        }
        return maxLength;
    }
}