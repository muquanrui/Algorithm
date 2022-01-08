package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 08/01/2022 13:02
 */
public class LeetCode0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] disappear = new int[nums.length + 1];
        for (int i: nums) {
            disappear[i] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < disappear.length; i++) {
            if (disappear[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
