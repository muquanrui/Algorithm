package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 05/03/2022 16:04
 */
public class LeetCode0090 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList.add(new ArrayList<>());
        Arrays.sort(nums);
        backtracking(nums, 0);
        return resList;
    }

    private void backtracking(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                    continue;
            }
            list.add(nums[i]);
            resList.add(new ArrayList<>(list));
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
