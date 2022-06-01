package ink.vor.notquiteac;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/6/1 13:12
 */

// https://leetcode.cn/problems/implement-strstr/
public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int j = 0;
        int[] prefixTable = getPrefixTable(needle);
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (haystack.charAt(i) != needle.charAt(j)) {
                continue;
            }
            j++;
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = prefixTable[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = prefixTable[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                prefixTable[i] = j + 1;
            }
        }
        return prefixTable;
    }
}
