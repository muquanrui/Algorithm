package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/4 16:35
 */

public class LeetCode1802 {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            long sum = getSum(mid, index + 1) + getSum(mid, n - index) - mid;
            if (sum <= maxSum) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long getSum(long max, int count) {
        if (max >= count) {
            return (max + (max - count + 1)) * count / 2;
        } else {
            return (max + 1) * max / 2 + (count - max);
        }
    }
}
