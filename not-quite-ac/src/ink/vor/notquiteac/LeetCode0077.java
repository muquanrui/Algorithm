package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/3 16:38
 */

// https://leetcode.cn/problems/combinations/
public class LeetCode0077 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return resList;
    }
    private void backtracking(int start, int n, int k) {
        if (list.size() == k) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = start; i <= n && k - list.size() <= n - i + 1; i++) {
            list.addLast(i);
            backtracking(i + 1, n, k);
            list.removeLast();
        }
    }
}
