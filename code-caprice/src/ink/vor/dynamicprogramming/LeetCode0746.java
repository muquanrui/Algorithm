package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/11 20:58
 */
public class LeetCode0746 {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;
        int f2 = 0;
        int fn = 0;
        for (int i = 2; i <= cost.length; i++) {
            fn = Math.min(cost[i - 2] + f1, cost[i - 1] + f2);
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
