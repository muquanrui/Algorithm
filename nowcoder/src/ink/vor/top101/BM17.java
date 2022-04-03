package ink.vor.top101;

/**
 * @author muquanrui
 * @date 03/04/2022 02:33
 */
public class BM17 {
    public int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
