package ink.vor.stacketqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author muquanrui
 * @date 16/02/2022 21:42
 */
public class LeetCode0225 {
}

class MyStack {
    Queue<Integer> queueIn;
    Queue<Integer> queueOut;

    public MyStack() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }

    public void push(int x) {
        queueIn.add(x);
    }

    public int pop() {
        return pourElement();
    }

    public int top() {
        int tail = pourElement();
        push(tail);
        return tail;
    }

    private int pourElement() {
        if (queueIn.isEmpty()) {
            return pourElement(queueOut, queueIn);
        } else {
            return pourElement(queueIn, queueOut);
        }
    }

    private int pourElement(Queue<Integer> queueToRetrieve, Queue<Integer> queueToAdd) {
        int tail = 0;
        while (!queueToRetrieve.isEmpty()) {
            tail = queueToRetrieve.remove();
            if (!queueToRetrieve.isEmpty()) {
                queueToAdd.add(tail);
            }
        }
        return tail;
    }

    public boolean empty() {
        return queueIn.isEmpty() && queueOut.isEmpty();
    }
}

