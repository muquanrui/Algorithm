package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 10/12/2021 14:06
 */
public class LeetCode0078 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
        for (List<Integer> list: resList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public static List<List<Integer>> resList;

    public static List<List<Integer>> subsets(int[] nums) {
        resList = new ArrayList<>();
        recursiveSub(nums, 0, new ArrayList<>());
        return resList;
    }

    public static void recursiveSub(int[] nums, int startIndex, List<Integer> list){
        List<Integer> tempList = new ArrayList<>(list);
        resList.add(tempList);
        for (int i = startIndex; i < nums.length; i++) {
            tempList.add(nums[i]);
            recursiveSub(nums, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}