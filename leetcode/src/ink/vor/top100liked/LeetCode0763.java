package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 09/01/2022 12:12
 */
public class LeetCode0763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        for (int i = s.length() - 1; i > -1; i--) {
            int ch = s.charAt(i) - 'a';
            if (lastIndex[ch] == -1) {
                lastIndex[ch] = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            last = Math.max(last, lastIndex[ch]);
            if (i == last) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
