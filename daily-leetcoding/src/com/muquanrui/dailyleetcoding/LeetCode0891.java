package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/11/18 12:19
 */

// https://leetcode.cn/problems/sum-of-subsequence-widths/description/
public class LeetCode0891 {
    static int N = 100010, MOD = (int)1e9+7;
    static long[] p = new long[N];
    static {
        p[0] = 1;
        for (int i = 1; i < N; i++) p[i] = p[i - 1] * 2 % MOD;
    }
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            ans += (p[i] * nums[i]) % MOD;
            ans %= MOD;
            ans -= (p[n - i - 1] * nums[i]) % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }
}
