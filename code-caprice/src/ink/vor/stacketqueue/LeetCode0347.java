package ink.vor.stacketqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/5/3 15:16
 */
public class LeetCode0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry);
            } else {
                if (entry.getValue() > heap.peek().getValue()) {
                    heap.offer(entry);
                    heap.poll();
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
