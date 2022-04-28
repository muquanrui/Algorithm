package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/28 18:04
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] * a[i - 1];
        }
        int[] reverse = new int[a.length];
        reverse[a.length - 1] = a[a.length - 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] *= reverse[i + 1];
            reverse[i] = reverse[i + 1] * a[i];
        }
        return dp;
    }
}
