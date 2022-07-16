package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/16 10:55
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 0) {
                continue;
            }
            int tmp = nums[fast];
            nums[fast] = nums[slow];
            nums[slow] = tmp;
            slow++;
        }
        return nums;
    }
}
