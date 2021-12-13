package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 13/12/2021 10:52
 */
public class LeetCode0096 {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
