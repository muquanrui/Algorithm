package com.muquanrui.notquiteac.onceagain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/22 19:56
 */

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 滑动窗口，单调递增队列
 */
public class LeetCode0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = queue.peekFirst();
                if (nums[i - k + 1] == queue.peekFirst()) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
