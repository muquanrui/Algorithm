package ink.vor.notquiteac;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/6/12 18:09
 */
public class LeetCode0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i + 1;
                int curRes = 1;
                while (set.contains(cur)) {
                    cur++;
                    curRes++;
                }
                res = Math.max(res, curRes);
            }
        }
        return res;
    }
}
