package ink.vor.monotonicstack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/15 17:52
 */
public class LeetCode0084 {
    public int largestRectangleArea(int[] heights) {
        int[] minLeft = new int[heights.length];
        Arrays.fill(minLeft, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                minLeft[stack.pop()] = i;
            }
            stack.push(i);
        }
        int[] minRight = new int[heights.length];
        Arrays.fill(minRight, heights.length);
        stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
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
