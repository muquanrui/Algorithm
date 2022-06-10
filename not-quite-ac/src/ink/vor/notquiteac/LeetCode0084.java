package ink.vor.notquiteac;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/10 17:12
 */

// https://leetcode.cn/problems/largest-rectangle-in-histogram/
public class LeetCode0084 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] minLeft = new int[heights.length];
        Arrays.fill(minLeft, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                minLeft[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack = new LinkedList<>();
        int[] minRight = new int[heights.length];
        Arrays.fill(minRight, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                minRight[stack.pop()] = i;
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (minRight[i] - minLeft[i] - 1) * heights[i]);
        }
        return res;
    }
}
