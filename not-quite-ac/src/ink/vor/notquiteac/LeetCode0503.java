package ink.vor.notquiteac;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/30 18:05
 */
public class LeetCode0503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            int cur = i % nums.length;
            while (!stack.isEmpty() && nums[cur] > nums[stack.peek()]) {
                res[stack.pop()] = nums[cur];
            }
            stack.push(cur);
        }
        return res;
    }
}
