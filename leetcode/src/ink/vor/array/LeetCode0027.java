package ink.vor.array;

/**
 * @author muquanrui
 * @date 17/01/2022 15:46
 */
public class LeetCode0027 {
//    public int removeElement(int[] nums, int val) {
//        int left;
//        int right = nums.length - 1;
//        for (left = 0; left <= right; left++) {
//            if (nums[left] == val) {
//                while (left <= right && nums[right] == val) {
//                    right--;
//                }
//                if (left >= right) {
//                    return right + 1;
//                } else {
//                    nums[left] = nums[right];
//                    nums[right] = val;
//                }
//            }
//        }
//        return right + 1;
//    }
    public int removeElement(int[] nums, int val) {
        int slow;
        int fast;
        for (slow = 0, fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
