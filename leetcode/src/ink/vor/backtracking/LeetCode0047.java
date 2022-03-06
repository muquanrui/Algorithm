package ink.vor.backtracking;

import java.util.*;

/**
 * @author muquanrui
 * @date 06/03/2022 21:51
 */
public class LeetCode0047 {
    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    private boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0);
        return resList;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] == true || (i > 0 && nums[i] == nums[i - 1] && isVisited[i - 1] == false)) {
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
