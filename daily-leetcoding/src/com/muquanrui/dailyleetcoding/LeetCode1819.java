package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/1/14 22:15
 */

public class LeetCode1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int g = 0;
            for (int cur = i; cur <= max; cur += cur) {
                if (set.contains(cur)) {
                    g = gcd(g, cur);
                    if (g == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
