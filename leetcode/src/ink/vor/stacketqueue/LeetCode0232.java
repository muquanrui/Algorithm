package ink.vor.stacketqueue;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 16/02/2022 21:07
 */
public class LeetCode0232 {

}

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        pourElements();
        return stackOut.pop();
    }

    public int peek() {
        pourElements();
        return stackOut.peek();
    }

    private void pourElements() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
}

