package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2023/2/24 13:32
 */

public class LeetCode2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[i] -= sum;
            if (nums[i] > 0) {
                count++;
            }
            sum += nums[i];
        }

        return count;
    }
}
