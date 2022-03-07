package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 07/03/2022 22:32
 */
public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
