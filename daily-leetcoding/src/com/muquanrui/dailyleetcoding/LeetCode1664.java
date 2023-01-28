package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/28 12:00
 */

public class LeetCode1664 {
    public int waysToMakeFair(int[] nums) {
        int[] oddLeft = new int[nums.length];
        int[] oddRight = new int[nums.length];
        int[] evenLeft = new int[nums.length];
        int[] evenRight = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                oddLeft[i] = oddLeft[i - 1] + nums[i - 1];
                evenLeft[i] = evenLeft[i - 1];
            } else {
                evenLeft[i] = evenLeft[i - 1] + nums[i - 1];
                oddLeft[i] = oddLeft[i - 1];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                oddRight[i] = oddRight[i + 1] + nums[i + 1];
                evenRight[i] = evenRight[i + 1];
            } else {
                evenRight[i] = evenRight[i + 1] + nums[i + 1];
                oddRight[i] = oddRight[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (oddLeft[i] + evenRight[i] == evenLeft[i] + oddRight[i]) {
                ans++;
            }
        }
        return ans;
    }
}
