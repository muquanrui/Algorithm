package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 08/03/2022 21:12
 */
public class LeetCode0122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
