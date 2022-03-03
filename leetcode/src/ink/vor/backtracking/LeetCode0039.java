package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 03/03/2022 20:53
 */
public class LeetCode0039 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return resList;
    }
    private void backTracking(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            list.addLast(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i, sum);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
