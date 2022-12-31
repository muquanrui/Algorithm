package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/12/31 23:42
 */

public class LeetCode2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(students[i] - seats[i]);
        }
        return ans;
    }
}
