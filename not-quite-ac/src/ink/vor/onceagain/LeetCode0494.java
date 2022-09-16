package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/29 16:19
 */

/**
 * https://leetcode.cn/problems/target-sum/
 * 动态规划，背包问题
 */
public class LeetCode0494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum + target) % 2 == 1 || (sum + target) / 2 > sum || (sum + target) / 2 < 0) {
            return 0;
        }
        target = (sum + target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = target; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        return dp[target];
    }
}
