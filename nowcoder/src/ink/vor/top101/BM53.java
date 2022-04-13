package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/13 18:31
 */
public class BM53 {
    public int minNumberDisappeared (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
