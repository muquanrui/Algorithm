package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/5/9 11:29
 */
public class LeetCode0455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexS = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (indexS < 0) {
                return count;
            }
            if (g[i] <= s[indexS]) {
                count++;
                indexS--;
            }
        }
        return count;
    }
}
