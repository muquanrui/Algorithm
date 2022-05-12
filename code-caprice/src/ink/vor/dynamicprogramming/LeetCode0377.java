package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 22:13
 */
public class LeetCode0377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
