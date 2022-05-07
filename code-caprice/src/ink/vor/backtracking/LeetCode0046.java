package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:33
 */
public class LeetCode0046 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
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
            if (isVisited[i]) {
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
