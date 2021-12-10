package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 03/12/2021 14:22
 */
public class LeetCode0035 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        if (left >= nums.length || nums[left] > target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
