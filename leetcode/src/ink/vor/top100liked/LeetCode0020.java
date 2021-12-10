package ink.vor.top100liked;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 30/11/2021 17:13
 */
public class LeetCode0020 {
    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "[[[";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !getMatch(c, stack.pop())) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getMatch(char c, char match) {
        if (c == '}') {
            return match == '{';
        } else if (c == ']') {
            return match == '[';
        } else {
            return match == '(';
        }
    }
}
