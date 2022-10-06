package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/10/4 20:34
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */
public class LeetCode0921 {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int countLeft = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                countLeft++;
            } else {
                if (countLeft > 0) {
                    countLeft--;
                } else {
                    res++;
                }
            }
        }
        res += countLeft;
        return res;
    }
}
