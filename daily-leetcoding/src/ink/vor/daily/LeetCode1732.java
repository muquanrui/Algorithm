package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/11/19 17:53
 */

// https://leetcode.cn/problems/find-the-highest-altitude/
public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i : gain) {
            sum += i;
            max = Math.max(max, sum);
        }
        return max;
    }
}
