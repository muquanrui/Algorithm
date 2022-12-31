package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/2 16:32
 */

/**
 * https://leetcode.cn/problems/backspace-string-compare/
 * 字符串，栈
 */
public class LeetCode0844 {
    public boolean backspaceCompare(String s, String t) {
        return getRealString(s).equals(getRealString(t));
    }

    private String getRealString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else if (ch != '#'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
