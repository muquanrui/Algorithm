package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/13 19:06
 */
public class LeetCode0121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
