package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 06/03/2022 21:33
 */
public class LeetCode0046 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    private boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        backtracking(nums, 0);
        return resList;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            resList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] == true) {
                continue;
            }
            isVisited[i] = true;
            list.addLast(nums[i]);
            backtracking(nums, depth + 1);
            list.removeLast();
            isVisited[i] = false;
        }
    }
}
