package ink.vor.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 09/02/2022 17:58
 */
public class LeetCode0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return null;
    }
}
