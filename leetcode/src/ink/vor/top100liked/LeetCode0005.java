package ink.vor.top100liked;

import java.util.HashMap;

/**
 * @author muquanrui
 * @date 27/11/2021 20:42
 */
public class LeetCode0005 {
    public static void main(String[] args) {
        String s1 = "madam and nursesrun is palindromic string.";
        String s = "aabba";
        System.out.println(longestPalindrome(s1));
    }

    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int startIndex= 0;
        for (int i = 0; i < s.length(); i++) {
            int length = Math.max(getLength(s, i, i), getLength(s, i, i + 1));
            if (maxLength < length) {
                maxLength = length;
                startIndex = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public static int getLength(String s, int l, int r) {
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}