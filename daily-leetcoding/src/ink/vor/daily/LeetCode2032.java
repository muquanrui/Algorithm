package ink.vor.daily;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/12/29 00:08
 */

public class LeetCode2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if ((val & (val - 1)) != 0) {
                resList.add(entry.getKey());
            }
        }
        return resList;
    }
}
