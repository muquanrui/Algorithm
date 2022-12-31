package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 15:54
 */

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 变化的二分查找
 */
public class LeetCode0033 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 中位数等于target直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 分情况讨论：中位数比右端小 -> mid到right是升序；中位数比右端大 -> left到mid是升序
            // 让搜索区间尽量定位到单调区间
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
