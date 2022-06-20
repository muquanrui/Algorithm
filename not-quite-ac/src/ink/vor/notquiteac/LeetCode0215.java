package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/20 17:05
 */
public class LeetCode0215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length - k, 0, nums.length - 1);
    }
    private int findKthLargest(int[] nums, int target, int left, int right) {
        int i = quickSort(nums, left, right);
        if (i > target) {
            return findKthLargest(nums, target, left, i - 1);
        } else if (i < target) {
            return findKthLargest(nums, target, i + 1, right);
        } else {
            return nums[i];
        }
    }
    private int quickSort(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] > pivot){
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] < pivot) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = pivot;
        return l;
    }
}
