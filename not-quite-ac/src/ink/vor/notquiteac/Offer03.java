package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/9 16:35
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i]] != nums[i]) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1;
    }
}
