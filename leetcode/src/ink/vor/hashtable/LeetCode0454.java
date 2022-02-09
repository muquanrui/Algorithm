package ink.vor.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 09/02/2022 18:03
 */
public class LeetCode0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap1et2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sumMap1et2.put(nums1[i] + nums2[j], sumMap1et2.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                res = sumMap1et2.get(0 - sum) == null ? 0 + res : sumMap1et2.get(0 - sum) + res;
            }
        }
        return res;
    }
}
