package ink.vor.backtracking;

import java.util.*;

/**
 * @author muquanrui
 * @date 05/03/2022 16:11
 */
public class LeetCode0491 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return resList;
    }

    private void backtracking(int[] nums, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (list.size() == 0 || nums[i] >= list.getLast()) {
                list.addLast(nums[i]);
                if (list.size() > 1) {
                    resList.add(new ArrayList<>(list));
                }
                backtracking(nums, i + 1);
                list.removeLast();
            }
        }
    }
}
