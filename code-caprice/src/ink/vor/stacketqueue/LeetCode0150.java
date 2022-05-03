package ink.vor.stacketqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/3 14:43
 */
public class LeetCode0150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            char ch = str.charAt(0);
            if (str.length() == 1 && (ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (ch == '+') {
                    stack.push(op1 + op2);
                } else if (ch == '-') {
                    stack.push(op1 - op2);
                } else if (ch == '*') {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op1 / op2);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
