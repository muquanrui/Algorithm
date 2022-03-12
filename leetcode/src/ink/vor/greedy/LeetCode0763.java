package ink.vor.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 12/03/2022 14:58
 */
public class LeetCode0763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for (int i = s.length() - 1; i > -1; i--) {
            char ch = s.charAt(i);
            if (lastIndex[ch - 'a'] == -1) {
                lastIndex[ch - 'a'] = i;
            }
        }
        int start = 0;
        int last = 0;
        List<Integer> resList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            last = Math.max(last, lastIndex[ch - 'a']);
            if (last == i) {
                resList.add(last - start + 1);
                start = i + 1;
            }
        }
        return resList;
    }
}
