package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/16 20:32
 */
public class BM69 {
    public int solve (String nums) {
        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < nums.length() + 1; i++) {
            dp[i] += dp[i - 1];
            int cur = Integer.parseInt(nums.substring(i - 2, i));
            if (cur > 10 && cur < 27 && cur != 20) {
                dp[i] += dp[i - 2];
            }
            if (nums.charAt(i - 1) == '0' && cur > 20) {
                return 0;
            }
        }
        return dp[nums.length()];
    }
}
