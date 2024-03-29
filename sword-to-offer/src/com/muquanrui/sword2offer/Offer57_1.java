package com.muquanrui.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 14:28
 */
public class Offer57_1 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
