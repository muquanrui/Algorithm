package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/18 11:40
 */

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/submissions/
 * 回溯算法
 */
public class Offer38 {
    List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] isVisited;
    public String[] permutation(String s) {
        isVisited = new boolean[s.length()];
        backtracking(s);
        String[] res = resList.toArray(new String[0]);
        return res;
    }
    private void backtracking(String s) {
        if (sb.length() == s.length()) {
            resList.add(sb.toString());
            return;
        }
        boolean[] dict = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (dict[ch - 'a'] || isVisited[i]) {
                continue;
            }
            dict[ch - 'a'] = true;
            isVisited[i] = true;
            sb.append(ch);
            backtracking(s);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
