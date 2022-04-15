package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 16:50
 */
public class BM64 {
    public int minCostClimbingStairs (int[] cost) {
        int curdash2 = 0;
        int curdash1 = 0;
        int cur = 0;
        for (int i = 2; i <= cost.length; i++) {
            cur = Math.min(curdash2 + cost[i - 2], curdash1 + cost[i - 1]);
            curdash2 = curdash1;
            curdash1 = cur;
        }
        return cur;
    }
}
