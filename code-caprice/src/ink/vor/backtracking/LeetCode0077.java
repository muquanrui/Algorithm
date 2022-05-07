package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:28
 */
public class LeetCode0077 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return resList;
    }

    private void backtracking(int n, int k, int start) {
        if (list.size() == k) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.addLast(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }
    }
}
