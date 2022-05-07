package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:31
 */
public class LeetCode0093 {
    List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return resList;
    }
    private void backtracking(String s, int start, int dotCount) {
        if (start == s.length()) {
            if (dotCount == 4) {
                resList.add(new String(sb.substring(0, sb.length() - 1)));
            }
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (sub.length() > 1 && (sub.charAt(0) == '0' || Integer.parseInt(sub) > 255)) {
                break;
            }
            sb.append(sub);
            sb.append('.');
            backtracking(s, end + 1, dotCount + 1);
            sb.delete(sb.length() - sub.length() - 1, sb.length());
        }
    }
}
