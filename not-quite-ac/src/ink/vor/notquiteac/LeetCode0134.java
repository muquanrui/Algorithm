package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/12 18:52
 */
public class LeetCode0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i;
                curSum = gas[i] - cost[i];
            } else {
                curSum += gas[i] - cost[i];
            }
        }
        return totalSum >= 0 ? start : -1;
    }
}
