package ink.vor.monotonicstack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/15 17:09
 */
public class LeetCode0503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int loop = 0; loop < 2; loop++) {
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
