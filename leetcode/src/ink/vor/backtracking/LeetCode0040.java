package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 03/03/2022 21:08
 */
public class LeetCode0040 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return resList;
    }
    private void backtracking(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            resList.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            list.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1, sum);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
