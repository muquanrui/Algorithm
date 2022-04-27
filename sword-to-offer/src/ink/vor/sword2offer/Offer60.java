package ink.vor.sword2offer;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/27 15:08
 */
public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int p = 0; p < 6; p++) {
                    tmp[j + p] += dp[j] * (1.0 / 6);
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
