package ink.vor.top101;

/**
 * @author muquanrui
 * @date 03/04/2022 03:34
 */
public class BM19 {
    public int findPeakElement (int[] nums) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
