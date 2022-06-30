package ink.vor.notquiteac;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/30 16:07
 */
public class LeetCode0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            res += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
