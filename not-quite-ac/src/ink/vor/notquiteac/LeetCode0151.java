package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/14 14:13
 */
public class LeetCode0151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int end = i;
            StringBuilder tmpSb = new StringBuilder();
            while (end < s.length() && s.charAt(end) != ' ') {
                tmpSb.append(s.charAt(end++));
            }
            i = end;
            tmpSb.reverse();
            sb.append(tmpSb.toString());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }
}