package ink.vor.daily;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/11/16 00:08
 */

// https://leetcode.cn/problems/global-and-local-inversions/
public class LeetCode0775 {
    public boolean isIdealPermutation(int[] nums) {
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i - 1] > min) {
                return false;
            }
            min = Math.min(min, nums[i]);
        }
        return true;
    }
    // public boolean isIdealPermutation(int[] nums) {
    //     int partialInversion = 0;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (nums[i] > nums[i + 1]) {
    //             partialInversion++;
    //         }
    //     }
    //     mergeAndSort(nums, 0, nums.length - 1);
    //     System.out.println(partialInversion + "  " + globalInversion);
    //     return globalInversion == partialInversion;
    // }
    //
    // int globalInversion = 0;
    // private void mergeAndSort(int[] nums, int left, int right) {
    //     if (left >= right) {
    //         return;
    //     }
    //     int mid = left + (right - left) / 2;
    //     mergeAndSort(nums, left, mid);
    //     mergeAndSort(nums, mid + 1, right);
    //     int l = left;
    //     int r = mid + 1;
    //     int[] temp = new int[right - left + 1];
    //     int i = 0;
    //     while (l <= mid && r <= right) {
    //         if (nums[l] <= nums[r]) {
    //             temp[i++] = nums[l++];
    //         } else {
    //             globalInversion += mid - l + 1;
    //             temp[i++] = nums[r++];
    //         }
    //     }
    //     while (l <= mid) {
    //         temp[i++] = nums[l++];
    //     }
    //     while (r <= right) {
    //         temp[i++] = nums[r++];
    //     }
    //     i = 0;
    //     for (int j = left; j <= right; j++) {
    //         nums[j] = temp[i++];
    //     }
    // }
}
