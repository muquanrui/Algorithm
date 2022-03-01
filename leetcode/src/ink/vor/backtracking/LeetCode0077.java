package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 01/03/2022 21:49
 */
public class LeetCode0077 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(1, n, k, new LinkedList<>());
        return resList;
    }

    public void combine(int start, int n, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            resList.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            combine(i + 1, n, k, list);
            list.removeLast();
        }
    }
}
