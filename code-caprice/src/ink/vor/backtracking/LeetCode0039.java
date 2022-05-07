package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:30
 */
public class LeetCode0039 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return resList;
    }

    private void backtracking(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            if (sum > target) {
                list.removeLast();
                break;
            }
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
