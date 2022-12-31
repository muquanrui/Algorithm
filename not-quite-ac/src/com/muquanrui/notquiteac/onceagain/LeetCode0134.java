package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/12 18:52
 */

/**
 * https://leetcode.cn/problems/gas-station/
 * 贪心算法
 */
public class LeetCode0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i;
                sum = gas[i] - cost[i];
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }
}
