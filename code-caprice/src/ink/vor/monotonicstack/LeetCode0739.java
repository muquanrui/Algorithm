package ink.vor.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/15 15:43
 */
public class LeetCode0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int out = stack.pop();
                res[out] = i - out;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int out = stack.pop();
            res[out] = 0;
        }
        return res;
    }
}
