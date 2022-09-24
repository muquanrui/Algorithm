package ink.vor.onceagain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/7/17 20:07
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int iPush = 0;
        for (int i = 0; i < popped.length; i++) {
            while (stack.isEmpty() || stack.peek() != popped[i]) {
                if (iPush >= pushed.length) {
                    return false;
                }
                stack.push(pushed[iPush++]);
            }
            stack.pop();
        }
        return true;
    }
}
