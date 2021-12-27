package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 27/12/2021 13:46
 */
public class LeetCode0215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
