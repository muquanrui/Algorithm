package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/11 19:07
 */

/**
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 位运算
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res = (n & 1) == 1 ? res + 1 : res;
            n >>>= 1;
        }
        return res;
    }
}
