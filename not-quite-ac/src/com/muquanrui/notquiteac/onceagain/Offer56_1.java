package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/20 14:27
 */

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 位运算
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int diff = 1;
        while ((xor & diff) == 0) {
            diff <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((i & diff) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
