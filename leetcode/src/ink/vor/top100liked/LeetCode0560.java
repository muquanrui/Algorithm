package ink.vor.top100liked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 08/01/2022 14:35
 */
public class LeetCode0560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixMap.containsKey(sum - k)) {
                res += prefixMap.get(sum - k);
            }
            prefixMap.put(sum, prefixMap.get(sum) == null ? 1 : prefixMap.get(sum) + 1);
        }
        return res;
    }
}
