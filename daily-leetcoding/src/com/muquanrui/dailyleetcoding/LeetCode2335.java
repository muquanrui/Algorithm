package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2023/2/11 12:39
 */

public class LeetCode2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0];
        int y = amount[1];
        int z = amount[2];
        if (x + y <= z) {
            return z;
        }
        return (x + y + z + 1) / 2;
    }
}
