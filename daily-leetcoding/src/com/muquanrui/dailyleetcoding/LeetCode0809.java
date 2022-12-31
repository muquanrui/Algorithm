package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/11/25 14:14
 */

// https://leetcode.cn/problems/expressive-words/description/
public class LeetCode0809 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length() && s.charAt(i) == word.charAt(j)) {
                int curI = i;
                int curJ = j;
                while (curI < s.length() && s.charAt(curI) == s.charAt(i)) {
                    curI++;
                }
                while (curJ < word.length() && word.charAt(curJ) == word.charAt(j)) {
                    curJ++;
                }
                int countI = curI - i;
                int countJ = curJ - j;
                if (countI == countJ || (countI > countJ && countI >= 3)) {
                    i = curI;
                    j = curJ;
                } else {
                    break;
                }
            }
            if (i == s.length() && j == word.length()) {
                res++;
            }
        }
        return res;
    }
}
