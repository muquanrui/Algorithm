package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 16:06
 */

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 变化的二分查找
 */
public class LeetCode0034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        // 往左找左端点，>= target时往左移动
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 注意可能找不到的情况
        if (left < nums.length && nums[left] == target) {
            res[0] = left;
        }
        left = 0;
        right = nums.length - 1;
        // 往右找右端点，<= target时往左移动
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 注意可能找不到的情况
        if (right >= 0 &&nums[right] == target) {
            res[1] = right;
        }
        return res;
    }
}
