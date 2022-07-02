package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/2 16:43
 */
public class LeetCode0763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            lastPos[ch] = lastPos[ch] == -1 ? i : lastPos[ch];
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            end = Math.max(end, lastPos[ch]);
            if (end == i) {
                list.add(end - start + 1);
                start = end + 1;
                end = end + 1;
            }
        }
        return list;
    }
}
