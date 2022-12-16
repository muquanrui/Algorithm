package ink.vor.daily;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/12/16 14:31
 */

public class LeetCode1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        long target = Math.abs(sum - goal);
        return (int) ((target + limit - 1) / limit);
    }
}
