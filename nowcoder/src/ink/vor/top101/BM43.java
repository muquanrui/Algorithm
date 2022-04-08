package ink.vor.top101;

import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 08/04/2022 02:18
 */
public class BM43 {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minRecordList = new LinkedList<>();

    public void push(int node) {
        stack.addLast(node);
        if (minRecordList.isEmpty()) {
            minRecordList.addLast(node);
            return;
        }
        minRecordList.addLast(Math.min(minRecordList.getLast(), node));
    }

    public void pop() {
        stack.removeLast();
        minRecordList.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int min() {
        return minRecordList.getLast();
    }
}
