package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 14:21
 */
public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
