package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 15:58
 */
public class LeetCode0055 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (far < i) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
            if (far >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
