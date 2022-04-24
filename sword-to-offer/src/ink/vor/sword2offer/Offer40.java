package ink.vor.sword2offer;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/4/24 15:04
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (Integer.compare(o2, o1)));
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.offer(arr[i]);
                continue;
            }
            if (arr[i] < heap.peek()) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
