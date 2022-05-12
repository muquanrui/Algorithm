package ink.vor.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/12 22:46
 */
public class LeetCode0279 {
    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i * i <= n; i++) {
            nums.add(i * i);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i : nums) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }
        return dp[n];
    }
}
