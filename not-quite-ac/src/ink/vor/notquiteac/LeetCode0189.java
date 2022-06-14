package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/14 15:45
 */
public class LeetCode0189 {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left++;
            right--;
        }
    }
}
