package ink.vor.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/5/2 12:02
 */
public class LeetCode0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
