package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 02/12/2021 08:21
 */
public class LeetCode0031 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 7, 4, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums);
        } else {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(i - 1, j, nums);
            j = nums.length - 1;
            while (i <= j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
