package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/20 20:26
 */

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 位运算
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] count1 = new int[32];
        for (int n : nums) {
            for (int i = 31; i >= 0; i--) {
                count1[i] += (n & 1);
                n >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (count1[i] % 3);
        }
        return res;
    }
}
