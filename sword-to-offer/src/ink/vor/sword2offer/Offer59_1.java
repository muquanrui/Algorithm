package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/27 15:07
 */
public class Offer59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() > 0 && i >= k && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }
            while (queue.size() > 0 && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = queue.peekFirst();
            }
        }
        return res;
    }
}
