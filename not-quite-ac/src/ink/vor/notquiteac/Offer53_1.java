package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/19 16:12
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
        int leftBound = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        leftBound = right + 1;
        int rightBound = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        rightBound = left - 1;
        return leftBound == -1 ? 0 : rightBound - leftBound + 1;
    }
}
