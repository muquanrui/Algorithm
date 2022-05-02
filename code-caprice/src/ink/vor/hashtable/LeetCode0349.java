package ink.vor.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/5/2 11:46
 */
public class LeetCode0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                resList.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
