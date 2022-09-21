package ink.vor.onceagain;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/30 18:05
 */

/**
 * https://leetcode.cn/problems/next-greater-element-ii/
 * 单调递增栈
 */
public class LeetCode0503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        return res;
    }
}
