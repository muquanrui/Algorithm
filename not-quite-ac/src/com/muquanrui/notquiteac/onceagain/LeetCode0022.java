package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/30 22:33
 */

/**
 * https://leetcode.cn/problems/generate-parentheses/
 * 递归回溯
 */
public class LeetCode0022 {
    private List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return resList;
    }
    // left统计左括号数，right统计右括号数
    private void backtracking(int left, int right, int n) {
        // 右括号数最大时得到一个结果
        if (right == n) {
            resList.add(sb.toString());
            return;
        }
        // 只要左括号数小于n，优先添加左括号
        if (left < n) {
            sb.append('(');
            backtracking(left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 右括号数必须比左括号数少时，才添加右括号
        if (right < left) {
            sb.append(')');
            backtracking(left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
