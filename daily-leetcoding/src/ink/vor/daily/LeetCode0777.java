package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/10/2 15:11
 */

/**
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */

public class LeetCode0777 {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        while (i < start.length() && j < end.length()) {
            char ch1 = start.charAt(i);
            char ch2 = end.charAt(j);
            if (ch1 == 'X') {
                i++;
                continue;
            }
            if (ch2 == 'X') {
                j++;
                continue;
            }
            if (ch1 != ch2 || (ch1 == 'L' && i < j) || (ch1 == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        while (i < start.length()) {
            if (start.charAt(i++) != 'X') {
                return false;
            }
        }
        while (j < start.length()) {
            if (end.charAt(j++) != 'X') {
                return false;
            }
        }
        return true;
    }
}
