package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 19/12/2021 10:50
 */
public class LeetCode0155 {
}

class MinStack {
    List<Integer> stack;
    List<Integer> minTilElement;

    public MinStack() {
        stack = new ArrayList<>();
        minTilElement = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minTilElement.size() == 0) {
            minTilElement.add(val);
        } else {
            minTilElement.add(Math.min(minTilElement.get(minTilElement.size() - 1), val));
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        minTilElement.remove(minTilElement.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minTilElement.get(minTilElement.size() - 1);
    }
}

