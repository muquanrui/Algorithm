package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/27 16:34
 */

/**
 * https://leetcode.cn/problems/combination-sum-iv/
 * 动态规划，背包问题
 */
public class LeetCode0377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (j <= i) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }
}
