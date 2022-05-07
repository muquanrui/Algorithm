package ink.vor.backtracking;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/5/7 22:32
 */
public class LeetCode0491 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return resList;
    }
    private void backtracking(int[] nums, int start) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (list.size() > 0 && nums[i] < list.getLast()) {
                continue;
            }
            if (map.get(nums[i]) != null) {
                continue;
            }
            map.put(nums[i], true);
            list.addLast(nums[i]);
            if (list.size() > 1) {
                resList.add(new ArrayList(list));
            }
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
