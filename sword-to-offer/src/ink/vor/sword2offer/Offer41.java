package ink.vor.sword2offer;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/4/24 15:04
 */
public class Offer41 {
}

class MedianFinder {
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;
    /** initialize your data structure here. */
    public MedianFinder() {
        firstHalf = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        secondHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (firstHalf.size() == secondHalf.size()) {
            secondHalf.offer(num);
            firstHalf.offer(secondHalf.poll());
        } else {
            firstHalf.offer(num);
            secondHalf.offer(firstHalf.poll());
        }
    }

    public double findMedian() {
        if (secondHalf.size() == firstHalf.size()) {
            return (firstHalf.peek() + secondHalf.peek()) / 2.0;
        }
        return firstHalf.peek();
    }
}

