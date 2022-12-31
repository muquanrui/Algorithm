package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/12/20 16:12
 */

public class LeetCode1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 1;
        int right = max;
        while (left <= right) {
            int target = left + (right - left) / 2;
            long ops = 0;
            for (int n : nums) {
                ops += (n - 1) / target;
            }
            if (ops > maxOperations) {
                left = target + 1;
            } else {
                right = target - 1;
            }
        }
        return left;
    }
}
