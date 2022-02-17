package ink.vor.stacketqueue;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 17/02/2022 07:07
 */
public class LeetCode0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    if ((ch == ')' && stack.pop() == '(')
                            || (ch == ']' && stack.pop() == '[')
                            || (ch == '}' && stack.pop() == '{')) {
                        continue;
                    }
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
