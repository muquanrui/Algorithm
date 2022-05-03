package ink.vor.stacketqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/5/3 14:29
 */
public class LeetCode0020 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char match = stack.pop();
                if ((match == '(' && ch == ')')
                        || (match == '[' && ch == ']')
                        || (match == '{' && ch == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
