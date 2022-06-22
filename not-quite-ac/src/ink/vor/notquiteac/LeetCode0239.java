package ink.vor.notquiteac;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/22 19:56
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
            if (i < k - 1) {
                continue;
            }
            res[i - k + 1] = queue.peekFirst();
            if (nums[i - k + 1] == queue.peekFirst()) {
                queue.pollFirst();
            }
        }
        return res;
    }
}
