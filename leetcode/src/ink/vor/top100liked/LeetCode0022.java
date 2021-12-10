package ink.vor.top100liked;

import com.sun.source.tree.IfTree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 01/12/2021 13:34
 */
public class LeetCode0022 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }

    public static List<String> resList = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        resList = new ArrayList<>();
        recursionGenerate(n, n, "");
        return resList;
    }

    public static void recursionGenerate(int left, int right, String out) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            resList.add(out);
            return;
        }

        recursionGenerate(left - 1, right, out + "(");
        recursionGenerate(left, right - 1, out + ")");
    }
}
