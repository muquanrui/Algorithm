package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 13:29
 */
public class Offer53_2 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
