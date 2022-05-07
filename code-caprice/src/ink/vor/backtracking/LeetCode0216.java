package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:29
 */
public class LeetCode0216 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return resList;
    }

    private void backtracking(int k, int n, int start, int sum) {
        if (list.size() == k) {
            if (sum == n) {
                resList.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.addLast(i);
            sum += i;
            if (sum > n) {
                list.removeLast();
                break;
            }
            backtracking(k, n, i + 1, sum);
            sum -= i;
            list.removeLast();
        }
    }
}
