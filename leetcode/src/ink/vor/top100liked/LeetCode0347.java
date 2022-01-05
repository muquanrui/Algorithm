package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 05/01/2022 16:20
 */
public class LeetCode0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Map<Integer, List<Integer>> inverseMap = new HashMap<>();
        List<Integer> frequent = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (inverseMap.get(entry.getValue()) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                inverseMap.put(entry.getValue(), list);
            } else {
                inverseMap.get(entry.getValue()).add(entry.getKey());
            }
            frequent.add(entry.getValue());
        }
        frequent.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - (o1 - o2);
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = inverseMap.get(frequent.get(i)).get(0);
            inverseMap.get(frequent.get(i)).remove(0);
        }
        return res;
    }
}
