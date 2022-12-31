package com.muquanrui.dailyleetcoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/30 16:51
 */

public class LeetCode0784 {
    List<String> resList;
    StringBuilder sb;
    public List<String> letterCasePermutation(String s) {
        resList = new ArrayList<>();
        sb = new StringBuilder(s);
        backtracking(0);
        return resList;
    }

    private void backtracking(int i) {
        if (i == sb.length()) {
            resList.add(sb.toString());
            return;
        }
        backtracking(i + 1);
        if (Character.isLowerCase(sb.charAt(i))) {
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        } else if (Character.isUpperCase(sb.charAt(i))) {
            sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        } else {
            return;
        }
        backtracking(i + 1);
    }
}
