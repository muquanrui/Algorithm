package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/9 16:35
 */

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 数组，Hash
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i]] != nums[i]) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
            if (nums[nums[i]] == nums[i] && i != nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
