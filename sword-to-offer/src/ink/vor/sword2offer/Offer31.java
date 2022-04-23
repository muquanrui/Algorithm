package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/23 17:49
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int iPush = 0;
        int iPop = 0;
        while (iPush < pushed.length && iPop < popped.length) {
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
