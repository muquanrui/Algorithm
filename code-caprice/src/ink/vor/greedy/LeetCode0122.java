package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 15:48
 */
public class LeetCode0122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
