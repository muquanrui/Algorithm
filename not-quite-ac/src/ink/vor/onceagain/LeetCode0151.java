package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/14 14:13
 */

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 字符串
 */
public class LeetCode0151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int end = i;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            for (int j = end - 1; j >= i; j--) {
                sb.append(s.charAt(j));
            }
            sb.append(' ');
            i = end;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }
}