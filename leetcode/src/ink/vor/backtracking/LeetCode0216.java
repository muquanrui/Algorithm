package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 01/03/2022 22:23
 */
public class LeetCode0216 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(1, k ,n, 0);
        return resList;
    }

    public void combinationSum3(int start, int k, int n, int sum) {
        if (list.size() == k - 1) {
            int diff = n - sum;
            if (diff >= start && diff <= 9) {
                list.addLast(diff);
                resList.add(new ArrayList<>(list));
                list.removeLast();
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            list.addLast(i);
            sum += i;
            if (sum + (k - list.size()) * (2 * i + 1 + k - list.size()) / 2 > n) {
                list.removeLast();
                break;
            }
            combinationSum3(i + 1, k, n, sum);
            sum -= i;
            list.removeLast();
        }
    }
}
