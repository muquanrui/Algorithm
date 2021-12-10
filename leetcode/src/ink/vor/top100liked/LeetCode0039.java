package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 03/12/2021 14:57
 */
public class LeetCode0039 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,7,6,3,5,1};
        List<List<Integer>> newResList = combinationSum(candidates, 9);
        for (List<Integer> list: newResList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> resList = new ArrayList<>();
    public static List<Integer> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursionSearch(candidates, 0, target);
        List<List<Integer>> newResList = new ArrayList<>();
        for (List<Integer> list: resList) {
            newResList.add(new ArrayList<>(list));
        }
        resList.clear();
        return newResList;
    }

    public static void recursionSearch(int[] candidates, int startIndex, int target) {
        if (target == 0) {
            resList.add(new ArrayList<>(res));
            if (res.size() > 0) {
                res.remove(res.size() - 1);
            }
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                res.add(candidates[i]);
                recursionSearch(candidates, i,target - candidates[i]);
            } else {
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                }
                return;
            }
        }
        if (res.size() > 0) {
            res.remove(res.size() - 1);
        }
    }

}
