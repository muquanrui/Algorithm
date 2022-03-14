package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 14/03/2022 21:20
 */
public class LeetCode0714 {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int stock = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < stock) {
                stock = prices[i];
            }
            if (prices[i] > stock + fee) {
                profit += prices[i] - stock - fee;
                stock = prices[i] - fee;
            }
        }
        return profit;
    }
}
