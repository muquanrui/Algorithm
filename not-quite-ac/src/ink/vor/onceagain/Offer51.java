package ink.vor.onceagain;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/7/19 16:30
 */
public class Offer51 {
    public int reversePairs(int[] nums) {
        divideAndMerge(nums, 0, nums.length - 1);
        return res;
    }

    int res = 0;
    private void divideAndMerge(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        divideAndMerge(nums, left, mid);
        divideAndMerge(nums, mid + 1, right);
        int[] arr = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (nums[l] > nums[r]) {
                arr[i++] = nums[l++];
                res += right - r + 1;
            } else {
                arr[i++] = nums[r++];
            }
        }
        while (l <= mid) {
            arr[i++] = nums[l++];
        }
        while (r <= right) {
            arr[i++] = nums[r++];
        }
        i = 0;
        for (int j = left; j <= right; j++) {
            nums[j] = arr[i++];
        }
    }
}
