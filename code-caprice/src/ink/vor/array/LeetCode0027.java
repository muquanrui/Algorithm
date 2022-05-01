package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 14:18
 */
public class LeetCode0027 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
