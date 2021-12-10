package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author muquanrui
 * @date 29/11/2021 15:24
 */
public class LeetCode0015 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] nums = new int[]{0, 0};
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//
//        for (int l = 0; l < nums.length && nums[l] <= 0; l++) {
//            int r = nums.length - 1;
//            while (r > -1 && nums[r] >= 0) {
//                while (r > -1 && 2 * nums[l] + nums[r] > 0) {
//                    r--;
//                }
//                if (l >= r || nums[l] > 0 || nums[r] < 0) {
//                    break;
//                }
//                int tryIndex = Arrays.binarySearch(nums, l + 1, r, 0 - nums[l] - nums[r]);
//                if (tryIndex >= 0) {
//                    List<Integer> select = new ArrayList<>();
//                    select.add(nums[l]);
//                    select.add(nums[tryIndex]);
//                    select.add(nums[r]);
//                    res.add(select);
//                }
//                int rightVal = nums[r];
//                while (r > -1 && nums[r] == rightVal) {
//                    r--;
//                }
//            }
//            int leftVal = nums[l];
//            while (l + 1 < nums.length && nums[l + 1] == leftVal) {
//                l++;
//            }
//        }
//        return res;
//    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer thirdIndex = map.get(0 - nums[i] - nums[j]);
                if (thirdIndex != null) {
                    if (i < j && j < thirdIndex){
                        List<Integer> select = new ArrayList<>();
                        select.add(nums[i]);
                        select.add(nums[j]);
                        select.add(nums[thirdIndex]);
                        resList.add(select);
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return resList;
    }
}