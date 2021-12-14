package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 14/12/2021 20:23
 */
public class LeetCode0121 {

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = min;
            } else if (prices[i] > max) {
                max = prices[i];
                res = Math.max(max - min, res);
            }
        }
        return res;
    }
}
