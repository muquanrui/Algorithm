package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:33
 */
public class LeetCode0047 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        isVisited = new boolean[nums.length];
        backtracking(nums);
        return resList;
    }

    private void backtracking(int[] nums) {
        if (list.size() == nums.length) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            list.addLast(nums[i]);
            backtracking(nums);
            list.removeLast();
            isVisited[i] = false;
        }
    }
}
