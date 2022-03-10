package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 10/03/2022 20:18
 */
public class LeetCode0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int tempSum = 0;
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            if (diff >= 0 && (tempSum < 0 || i == 0)) {
                start = i;
                tempSum = 0;
            }
            tempSum += diff;
        }
        return sum < 0 ? -1 : start;
    }
}
