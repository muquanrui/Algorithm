package ink.vor.stacketqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/3 13:58
 */
public class LeetCode0225 {
}

class MyStack {
    Deque<Integer> queue;
    Deque<Integer> queueHelper;

    public MyStack() {
        queue = new LinkedList<>();
        queueHelper = new LinkedList<>();
    }

    public void push(int x) {
        queueHelper.offer(x);
        while (!queue.isEmpty()) {
            queueHelper.offer(queue.poll());
        }
        Deque<Integer> tmpQueue = queueHelper;
        queueHelper = queue;
        queue = tmpQueue;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}