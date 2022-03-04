package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 04/03/2022 19:56
 */
public class LeetCode0093 {
    private List<String> resList = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return resList;
    }

    private void backtracking(String s, int start, int dotCount) {
        if (start == s.length()) {
            if (dotCount == 4) {
                resList.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        int i = dotCount == 3 ? s.length() - 1 : start;
        for (; i < start + 3 && i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if ((str.length() > 1) && (str.charAt(0) == '0' || Integer.parseInt(str) > 255)) {
                return;
            }
            sb.append(str);
            sb.append(".");
            backtracking(s, i + 1, dotCount + 1);
            sb.delete(sb.length() - str.length() - 1, sb.length());
        }
    }
}
