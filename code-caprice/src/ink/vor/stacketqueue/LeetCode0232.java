package ink.vor.stacketqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/3 13:58
 */
public class LeetCode0232 {
}

class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;

    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            pourElements();
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            pourElements();
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void pourElements() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
