package ink.vor.stacketqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author muquanrui
 * @date 17/02/2022 08:06
 */
public class LeetCode0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.remove().getKey();
        }
        return res;
    }
}
