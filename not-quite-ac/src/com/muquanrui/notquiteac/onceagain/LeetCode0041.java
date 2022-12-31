package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 16:28
 */

/**
 * https://leetcode.cn/problems/first-missing-positive/
 * 数组
 */
public class LeetCode0041 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 把当前位置的元素放到它应该在的位置：下标nums[i] - 1
            // 把该位置原本的元素放到当前位置
            // 持续交换直到当前位置元素不满足继续交换情况
            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 检查缺失
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 不缺失返回后一个正整数
        return nums.length + 1;
    }
}
