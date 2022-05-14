package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/14 16:20
 */
public class LeetCode0392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
