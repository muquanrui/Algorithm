package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/16 11:43
 */

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 快慢双指针
 */
public class Offer26 {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}
