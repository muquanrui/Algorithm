package ink.vor.onceagain;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/6/26 12:48
 */

/**
 * https://leetcode.cn/problems/find-median-from-data-stream/
 * 优先权队列，一个小顶堆，一个大顶堆
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
        if (queue1.size() == queue2.size()) {
            queue2.offer(num);
            queue1.offer(queue2.poll());
        } else {
            queue1.offer(num);
            queue2.offer(queue1.poll());
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