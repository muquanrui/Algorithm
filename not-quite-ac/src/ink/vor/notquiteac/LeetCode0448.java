package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/28 12:41
 */
public class LeetCode0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            nums[(i - 1) % nums.length] += nums.length;
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                resList.add(i + 1);
            }
        }
        return resList;
    }
}
