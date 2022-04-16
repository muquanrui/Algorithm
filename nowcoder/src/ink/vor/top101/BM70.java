package ink.vor.top101;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/16 20:34
 */
public class BM70 {
    public int minMoney (int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < aim + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        return dp[aim] == Integer.MAX_VALUE - 1 ? -1 : dp[aim];
    }
}
