package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/12/27 00:06
 */

public class LeetCode2027 {
    public int minimumMoves(String s) {
        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'O') {
                i++;
                continue;
            }
            ans++;
            i += 3;
        }
        return ans;
    }
}
