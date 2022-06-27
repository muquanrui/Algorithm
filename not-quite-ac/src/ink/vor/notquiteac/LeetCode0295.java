package ink.vor.notquiteac;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/6/26 12:48
 */
public class LeetCode0295 {
}

class MedianFinder {
    PriorityQueue<Integer> queue1;
    PriorityQueue<Integer> queue2;
    public MedianFinder() {
        queue1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        queue2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (queue1.isEmpty()) {
            queue1.add(num);
            return;
        }
        if (queue1.size() > queue2.size()) {
            if (num < queue1.peek()) {
                queue2.offer(queue1.poll());
                queue1.offer(num);
            } else {
                queue2.offer(num);
            }
        } else {
            if (num > queue2.peek()) {
                queue1.offer(queue2.poll());
                queue2.offer(num);
            } else {
                queue1.offer(num);
            }
        }
    }

    public double findMedian() {
        if (queue1.size() == queue2.size()) {
            return (queue1.peek() + queue2.peek()) / 2.0;
        } else {
            return queue1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */