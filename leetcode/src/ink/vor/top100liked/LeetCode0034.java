package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 03/12/2021 14:01
 */
public class LeetCode0034 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int tempLeft = -1;
        int tempRight = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                tempLeft = mid;
                tempRight = mid;
                break;
            }
        }
        int[] index = new int[]{-1, -1};
        if (tempLeft == -1) {
            return index;
        }
        while (tempLeft > -1 && nums[tempLeft] == target) {
            tempLeft--;
        }
        while (tempRight < nums.length && nums[tempRight] == target) {
            tempRight++;
        }
        index[0] = tempLeft + 1;
        index[1] = tempRight - 1;
        return index;
    }
}
