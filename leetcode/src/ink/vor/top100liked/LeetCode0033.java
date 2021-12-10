package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 02/12/2021 09:00
 */
public class LeetCode0033 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4};
        System.out.println(search(nums, 4));
    }

    public static int search(int[] nums, int target) {
        int left = (nums.length - 1) / 2;
        int right = (nums.length + 1) / 2;
        while (left > -1 && right < nums.length && nums[left] < nums[right]) {
            left--;
            right++;
        }
        int rotateIndex = left > -1 && left + 1 < nums.length && nums[left] < nums[left + 1] ? right : left + 1;

        if (target < nums[0]) {
            left = rotateIndex;
            right = nums.length - 1;
        } else {
            left = 0;
            right = rotateIndex > 0 ? rotateIndex - 1 : nums.length - 1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
