package ink.vor.array;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 02/02/2022 17:05
 */
public class LeetCode0026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
