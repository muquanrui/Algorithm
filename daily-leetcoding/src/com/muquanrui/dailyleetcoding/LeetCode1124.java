package com.muquanrui.dailyleetcoding;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2023/2/14 14:58
 */

public class LeetCode1124 {
    public int longestWPI(int[] hours) {
        int[] prefixSum = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (hours[i] > 8 ? 1 : -1);
        }

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (stack.isEmpty() || prefixSum[i] < prefixSum[stack.peek()]) {
                stack.push(i);
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j = prefixSum.length - 1; j > i; j--) {
                if (prefixSum[j] > prefixSum[i]) {
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }

        return ans;
    }
}
