package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 05/03/2022 15:53
 */
public class LeetCode0078 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        resList.add(new ArrayList<>());
        backtracking(nums, 0);
        return resList;
    }

    private void backtracking(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            resList.add(new ArrayList<>(list));
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
