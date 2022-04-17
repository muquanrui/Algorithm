package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/17 20:18
 */
public class BM81 {
    public int maxProfit (int[] prices) {
        // write code here
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
