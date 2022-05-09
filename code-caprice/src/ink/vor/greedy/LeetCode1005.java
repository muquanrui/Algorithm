package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/5/9 16:27
 */
public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (i1, i2) -> Integer.compare(Math.abs(i1), Math.abs(i2)));
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 0 && k > 0) {
                sum -= arr[i];
                k--;
            } else {
                sum += arr[i];
            }
        }
        if (k % 2 == 1 && arr[0] != 0) {
            sum -= 2 * Math.abs(arr[0]);
        }
        return sum;
    }
}
