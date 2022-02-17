package ink.vor.stacketqueue;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 17/02/2022 07:20
 */
public class LeetCode1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (sb.isEmpty() || ch != sb.charAt(sb.length() - 1)) {
                sb.append(ch);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
