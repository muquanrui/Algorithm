package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 13:12
 */

/**
 * https://leetcode.cn/problems/implement-strstr/
 * KMP算法
 */
public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] prefixTable = getPrefixTable(needle);
        while (i < haystack.length()) {
            // 不相等时needle移动到前一个字符的最长前缀位置
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            i++;
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    // 获取前缀数组
    private int[] getPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        for (int i = 1; i < prefixTable.length; i++) {
            int j = prefixTable[i - 1];
            // 向前匹配
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
