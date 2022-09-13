package ink.vor.onceagain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/20 12:51
 */

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 队列，栈
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
        Deque<Integer> tmp = queue;
        queue = queueHelper;
        queueHelper = queue;
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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */