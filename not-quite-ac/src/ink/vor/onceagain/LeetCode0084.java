package ink.vor.onceagain;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/10 17:12
 */

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * 单调栈：单调递减
 */
public class LeetCode0084 {
    public int largestRectangleArea(int[] heights) {
        // 单调递减的栈
        Deque<Integer> stack = new LinkedList<>();
        // 记录i左侧最近的比i高度小的下标
        int[] left = new int[heights.length];
        // 记录i右侧最近的比i高度小的下标
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            // 注意如果栈为空，说明左边的高度都比i大
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            // 注意如果栈为空，说明右边的高度都比i大
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int res = 0;
        // 计算结果注意-1
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
