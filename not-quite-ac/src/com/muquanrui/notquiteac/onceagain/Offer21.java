package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/16 10:55
 */

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 快慢双指针
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 0) {
                continue;
            }
            if (slow != fast) {
                nums[slow] ^= nums[fast];
                nums[fast] ^= nums[slow];
                nums[slow] ^= nums[fast];
            }
            slow++;
        }
        return nums;
    }
}
