package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/11/23 20:37
 */

// https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
public class LeetCode1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[45];
        for (int i = lowLimit; i <= highLimit; i++) {
            int cur = i;
            int sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            count[sum - 1]++;
        }
        int max = count[0];
        for (int i = 0; i < 45; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
