package ink.vor.array;

/**
 * @author muquanrui
 * @date 01/02/2022 15:40
 */
public class LeetCode0034 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{getLowerBound(nums, target), getUpperBound(nums, target)};
    }

    public int getLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public int getUpperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
