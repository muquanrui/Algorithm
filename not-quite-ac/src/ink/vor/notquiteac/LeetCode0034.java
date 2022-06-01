package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/1 16:06
 */

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
public class LeetCode0034 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int[] res = new int[]{-1, -1};
        if (left < 1 || nums[left - 1] != target) {
            return res;
        }
        res[1] = left - 1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        res[0] = right + 1;
        return res;
    }
}
