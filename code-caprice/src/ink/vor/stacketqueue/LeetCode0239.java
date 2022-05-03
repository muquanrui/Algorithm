package ink.vor.stacketqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/3 15:01
 */
public class LeetCode0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
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
