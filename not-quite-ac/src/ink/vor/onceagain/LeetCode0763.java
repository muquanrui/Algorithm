package ink.vor.onceagain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/2 16:43
 */

/**
 * https://leetcode.cn/problems/partition-labels/
 * 字符串，滑动窗口
 */
public class LeetCode0763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (last[ch - 'a'] == -1) {
                last[ch - 'a'] = i;
            }
        }
        List<Integer> resList = new ArrayList<>();
        int left = 0;
        int far = -1;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            far = Math.max(far, last[ch - 'a']);
            if (right == far) {
                resList.add(right - left + 1);
                left = right + 1;
            }
        }
        return resList;
    }
}
