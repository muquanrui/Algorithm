package com.muquanrui.test;

/**
 * @author muquanrui
 * @date 2022/10/22 16:08
 */

public class Test34 {
    public int planStock (int[][] order, int balance) {
        // write code here
        int[] dp = new int[balance + 1];
        for (int[] arr : order) {
            int price = arr[0] * arr[1];
            for (int i = balance; i >= price; i--) {
                dp[i] = Math.max(dp[i], dp[i - price] + arr[1]);
            }
        }
        return dp[balance];
    }
}
