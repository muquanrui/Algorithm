package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/30 22:33
 */

// https://leetcode.cn/problems/generate-parentheses/
public class LeetCode0022 {
    public static List<String> resList = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        resList = new ArrayList<>();
        recursionGenerate(n, n, "");
        return resList;
    }

    public static void recursionGenerate(int left, int right, String out) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            resList.add(out);
            return;
        }
        recursionGenerate(left - 1, right, out + "(");
        recursionGenerate(left, right - 1, out + ")");
    }
}
