package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/27 15:08
 */
public class Offer59_2 {
}
class MaxQueue {
    Deque<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.size() == 0) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (maxQueue.size() > 0 && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        }
        int pop = queue.poll();
        if (pop == max_value()) {
            maxQueue.pollFirst();
        }
        return pop;
    }
}
