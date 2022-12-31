package com.muquanrui.dailyleetcoding;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/11/13 01:23
 */

// https://leetcode.cn/problems/custom-sort-string/
public class LeetCode0791 {
    public String customSortString(String order, String s) {
        int[] dict = new int[26];
        Arrays.fill(dict, -1);
        for (int i = 0; i < order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        char[][] record = new char[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            record[i] = new char[]{ch, (char)dict[ch - 'a']};
        }
        Arrays.sort(record, (arr1, arr2) -> {
            return arr1[1] - arr2[1];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < record.length; i++) {
            sb.append(record[i][0]);
        }
        return sb.toString();
    }
}
