package ink.vor.onceagain;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/6/13 12:52
 */

/**
 * https://leetcode.cn/problems/candy/
 * 贪心算法
 */
public class LeetCode0135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int res = 0;
        for (int i : candies) {
            res += i;
        }
        return res;
    }
}
