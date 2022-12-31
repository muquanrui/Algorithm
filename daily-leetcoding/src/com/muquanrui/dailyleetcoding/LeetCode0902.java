package com.muquanrui.dailyleetcoding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/18 22:27
 */

/**
 * https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 */
public class LeetCode0902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] nums = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        return calculate(nums, n);
    }

    private int calculate(int[] nums, int n) {
        List<Integer> eachDigitOfN = new ArrayList<>();
        while (n > 0) {
            eachDigitOfN.add(n % 10);
            n /= 10;
        }

        int ans = 0;
        int numberOfN = eachDigitOfN.size();
        int totalOptions = nums.length;
        for (int i = numberOfN - 1; i >= 0; i--) {
            int cur = eachDigitOfN.get(i);
            int rightBound = binarySearchRightBound(nums, cur);
            if (nums[rightBound] == cur) {
                ans += rightBound * (int) Math.pow(totalOptions, i);
                if (i == 0) {
                    ans += 1;
                }
            } else {
                if (nums[rightBound] < cur) {
                    ans += (rightBound + 1) * (int) Math.pow(totalOptions, i);
                }
                break;
            }
        }

        int lastOptions = 1;
        for (int i = 1; i <= numberOfN - 1; i++) {
            lastOptions *= totalOptions;
            ans += lastOptions;
        }
        return ans;
    }

    private int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1)  / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
