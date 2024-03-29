package com.muquanrui.codecaprice.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:31
 */
public class LeetCode0078 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        resList.add(new ArrayList());
        backtracking(nums, 0);
        return resList;
    }
    private void backtracking(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            list.addLast(nums[i]);
            resList.add(new ArrayList(list));
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
