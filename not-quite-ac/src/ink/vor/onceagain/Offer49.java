package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/19 13:38
 */

/**
 * https://leetcode.cn/problems/chou-shu-lcof/
 * 动态规划
 */
public class Offer49 {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int ai = dp[a] * 2;
            int bi = dp[b] * 3;
            int ci = dp[c] * 5;
            int min = Math.min(Math.min(ai, bi), ci);
            dp[i] = min;
            if (ai == min) {
                a++;
            }
            if (bi == min) {
                b++;
            }
            if (ci == min) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
