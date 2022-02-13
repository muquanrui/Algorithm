package ink.vor.doublepointer;

/**
 * @author muquanrui
 * @date 13/02/2022 23:13
 */
public class LeetCode0027 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
