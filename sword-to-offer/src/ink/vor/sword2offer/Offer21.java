package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/22 17:43
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            if (nums[odd] % 2 == 1) {
                odd++;
            }
            if (nums[even] % 2 == 0) {
                even--;
            }
            if (odd < even && nums[odd] % 2 == 0 && nums[even] % 2 == 1) {
                nums[odd] ^= nums[even];
                nums[even] ^= nums[odd];
                nums[odd] ^= nums[even];
                odd++;
                even--;
            }
        }
        return nums;
    }
}
