package ink.vor.top100liked;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 05/01/2022 16:45
 */
public class LeetCode0394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String chPop = stack.pop();
                StringBuilder sb = new StringBuilder();
                while (!chPop.equals("[")) {
                    sb.append(chPop);
                    chPop = stack.pop();
                }
                int repeat = Integer.parseInt(stack.pop());
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    temp.append(sb);
                }
                stack.push(temp.toString());
            } else {
                if (Character.isDigit(ch)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        i++;
                        sb.append(s.charAt(i));
                    }
                    stack.push(sb.toString());
                } else if (Character.isLowerCase(ch)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    while (i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) {
                        i++;
                        sb.append(s.charAt(i));
                    }
                    stack.push(sb.reverse().toString());
                } else {
                    stack.push(String.valueOf(ch));
                }
            }
        }

        StringBuilder decodeStr = new StringBuilder();
        while (!stack.isEmpty()) {
            decodeStr.append(stack.pop());
        }
        decodeStr.reverse();

        return decodeStr.toString();
    }
}
