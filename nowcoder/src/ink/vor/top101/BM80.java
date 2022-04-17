package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/17 20:18
 */
public class BM80 {
    public int maxProfit (int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
