package ink.vor.top101;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 10/04/2022 01:01
 */
public class BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k == 0) {
            return new ArrayList<Integer>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.offer(input[i]);
            } else {
                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
