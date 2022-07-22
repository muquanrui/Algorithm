package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/22 10:02
 */
public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] * 1.0 / 6;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
