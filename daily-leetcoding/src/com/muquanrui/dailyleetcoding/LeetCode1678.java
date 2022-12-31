package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/11/6 11:40
 */

// https://leetcode.cn/problems/goal-parser-interpretation/description/
public class LeetCode1678 {
    public String interpret(String command) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < command.length()) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append('G');
            } else {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            }
            i++;
        }
        return sb.toString();
    }
}
