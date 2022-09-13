package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/22 19:27
 */

/**
 * https://leetcode.cn/problems/single-number-iii/
 * 位运算
 */
public class LeetCode0260 {
    public int[] singleNumber(int[] nums) {
        int axorb = 0;
        for (int i : nums) {
            axorb ^= i;
        }
        int diff = 1;
        while ((diff & axorb) == 0) {
            diff <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((diff & i) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
