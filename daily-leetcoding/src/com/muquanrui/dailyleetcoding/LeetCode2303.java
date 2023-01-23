package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/23 23:40
 */

public class LeetCode2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        if (income <= brackets[0][0]) {
            return income * brackets[0][1] * 0.01;
        } else {
            ans += brackets[0][0] * brackets[0][1] * 0.01;
        }
        for (int i = 1; i < brackets.length; i++) {
            int cur = brackets[i][0];
            int rate = brackets[i][1];
            if (income <= cur) {
                ans += (income - brackets[i - 1][0]) * rate * 0.01;
                break;
            }
            ans += (cur - brackets[i - 1][0]) * rate * 0.01;
        }
        return ans;
    }
}
