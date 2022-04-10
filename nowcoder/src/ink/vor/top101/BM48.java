package ink.vor.top101;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 10/04/2022 22:00
 */
public class BM48 {
    PriorityQueue<Integer> smallHalf = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> largeHalf = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (smallHalf.size() == largeHalf.size()) {
            smallHalf.offer(num);
            largeHalf.offer(smallHalf.poll());
        } else {
            largeHalf.offer(num);
            smallHalf.offer(largeHalf.poll());
        }
    }

    public Double GetMedian() {
        if (smallHalf.size() == largeHalf.size()) {
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        } else {
            return largeHalf.peek().doubleValue();
        }
    }
}
