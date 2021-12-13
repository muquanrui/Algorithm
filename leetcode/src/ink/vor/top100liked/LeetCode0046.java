package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 06/12/2021 11:10
 */
public class LeetCode0046 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
        for (List l: resList) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public static List<List<Integer>> resList;
    public static List<Integer> tempList;
    public static int[] isVistied;

    public static List<List<Integer>> permute(int[] nums) {
        resList = new ArrayList<>();
        tempList = new ArrayList<>();
        isVistied = new int[nums.length];
        recursivePermute(nums);
        return resList;
    }

    public static void recursivePermute(int[] nums) {
        if (tempList.size() == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVistied[i] == 0) {
                isVistied[i] = 1;
                tempList.add(nums[i]);
                recursivePermute(nums);
                isVistied[i] = 0;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
