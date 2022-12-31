package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/12/25 14:09
 */

public class LeetCode1739 {
    public int minimumBoxes(int n) {
        int ans = 0;
        int maxN = 0;
        for (int i = 1; maxN + ans + i <= n; i++) {
            ans += i;
            maxN += ans;
        }
        for (int j = 1; maxN < n; j++) {
            ans++;
            maxN += j;
        }
        return ans;
    }
}
