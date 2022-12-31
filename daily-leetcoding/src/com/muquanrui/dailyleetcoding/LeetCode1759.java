package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/12/26 00:04
 */

public class LeetCode1759 {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        int i = 0;
        long ans = 0;
        while (i < s.length()) {
            int tmp = i;
            char ch = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)) {
                i++;
            }
            long op1 = i - tmp + 1;
            long op2 = i - tmp + 2;
            ans += op1 * op2 / 2 % MOD;
            i++;
        }
        return (int)ans;
    }
}
