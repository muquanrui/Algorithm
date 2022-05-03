package ink.vor.stacketqueue;

/**
 * @author muquanrui
 * @date 2022/5/3 14:43
 */
public class LeetCode1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(ch);
                continue;
            }
            char last = sb.charAt(sb.length() - 1);
            if (last == ch) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
