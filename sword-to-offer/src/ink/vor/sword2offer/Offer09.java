package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/21 14:52
 */
public class Offer09 {
}

class CQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    public CQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) {
            pourElements();
        }
        return stackOut.isEmpty() ? -1 : stackOut.pop();
    }

    private void pourElements() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}

