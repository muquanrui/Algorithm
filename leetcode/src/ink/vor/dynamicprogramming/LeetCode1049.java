package ink.vor.dynamicprogramming;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 18/03/2022 19:04
 */
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
