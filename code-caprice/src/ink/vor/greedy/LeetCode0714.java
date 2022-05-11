package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/11 20:27
 */
public class LeetCode0714 {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] + fee) {
                profit += prices[i] - prices[i - 1] - fee;
                prices[i] -= fee;
            } else if (prices[i] > prices[i - 1]) {
                prices[i] = prices[i - 1];
            }
        }
        return profit;
    }
}
