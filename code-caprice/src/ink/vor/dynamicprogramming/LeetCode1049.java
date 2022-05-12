package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 11:29
 */
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i : stones) {
            for (int j = target; j >= i; j--) {
                dp[j] = Math.max(dp[j], dp[j - i] + i);
            }
        }
        return sum - 2 * dp[target];
    }
}
