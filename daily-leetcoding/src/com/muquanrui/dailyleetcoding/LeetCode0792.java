package com.muquanrui.dailyleetcoding;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/11/17 00:24
 */

// https://leetcode.cn/problems/number-of-matching-subsequences/
public class LeetCode0792 {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] dict = new List[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (dict[index] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                dict[index] = list;
            } else {
                dict[index].add(i);
            }
        }

        int count = 0;
        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }
            int iInWord = 0;
            int iInS = 0;
            for (char ch : word.toCharArray()) {
                if (dict[ch - 'a'] == null) {
                    break;
                }
                List<Integer> list = dict[ch - 'a'];
                int nextiInS = binarySearch(list, iInS);
                if (iInS > nextiInS) {
                    break;
                }
                iInS = nextiInS;
                iInWord++;
            }
            if (iInWord == word.length()) {
                count++;
            }
        }
        return count;
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
