package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 21/03/2022 22:00
 */
public class LeetCode0121 {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }
}
