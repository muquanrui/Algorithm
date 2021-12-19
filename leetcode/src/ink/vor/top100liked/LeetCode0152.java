package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 19/12/2021 08:34
 */
public class LeetCode0152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = tripleMin(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i], nums[i]);
            dp[i][1] = tripleMax(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i], nums[i]);
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public int tripleMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int tripleMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
