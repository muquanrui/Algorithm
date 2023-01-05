package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/6 00:31
 */

public class LeetCode2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int cur = i;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            if (sum % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
