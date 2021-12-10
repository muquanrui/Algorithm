package ink.vor.top100liked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 10/12/2021 13:05
 */
public class LeetCode0075 {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] < 1) {
                left++;
            }
            while (right > -1 && nums[right] >= 1) {
                right--;
            }
            if (left >= right){
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] == 1) {
                left++;
            }
            while (right > -1 && nums[right] == 2) {
                right--;
            }
            if (left >= right){
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
