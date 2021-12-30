package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 30/12/2021 17:30
 */
public class LeetCode0283 {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (zeroIndex != -1 && nums[i] == 0) {
                zeroIndex = i;
            }
            if (zeroIndex != -1 && nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                zeroIndex++;
            }
        }
    }
}
