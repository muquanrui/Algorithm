package ink.vor.notquiteac;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/7/17 20:07
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int iPush = 0;
        int iPop = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (iPush < pushed.length) {
            if (stack.isEmpty() || stack.peek() != popped[iPop]) {
                stack.push(pushed[iPush++]);
            }
            while (!stack.isEmpty() && stack.peek() == popped[iPop]) {
                stack.pop();
                iPop++;
            }
        }
        return stack.isEmpty();
    }
}
