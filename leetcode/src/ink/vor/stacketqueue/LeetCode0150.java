package ink.vor.stacketqueue;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author muquanrui
 * @date 17/02/2022 07:35
 */
public class LeetCode0150 {
    public LeetCode0150() {
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
        for (String str: tokens) {
            // Matcher isInteger = pattern.matcher(str);
            if (!(str.equals("+")
            || str.equals("-")
            || str.equals("*")
            || str.equals("/"))) {
                stack.push(Integer.parseInt(str));
            } else {
                int operandAfter = stack.pop();
                int operandBefore = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(operandBefore + operandAfter);
                        break;
                    case "-":
                        stack.push(operandBefore - operandAfter);
                        break;
                    case "*":
                        stack.push(operandBefore * operandAfter);
                        break;
                    case "/":
                        stack.push(operandBefore / operandAfter);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
