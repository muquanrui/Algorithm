package ink.vor.top100liked;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author muquanrui
 * @date 25/11/2021 08:58
 */
public class LeetCode0001 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer res = map.get(target - nums[i]);
            if (res != null) {
                return new int[]{res, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
