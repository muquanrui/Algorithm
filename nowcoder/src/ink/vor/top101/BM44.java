package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 09/04/2022 23:28
 */
public class BM44 {
    public boolean isValid (String s) {
        // write code here
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char match = stack.pop();
                if (! ((ch == ')' && match == '(') ||
                        (ch == ']' && match == '[') ||
                        (ch == '}' && match == '{'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
