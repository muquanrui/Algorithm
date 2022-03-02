package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 02/03/2022 23:16
 */
public class LeetCode0455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int indexS = 0;
        for (int i = 0; i < g.length && indexS < s.length; i++) {
            if (g[i] >= s[indexS]) {
                indexS++;
                count++;
            }
        }
        return count;
    }
}
