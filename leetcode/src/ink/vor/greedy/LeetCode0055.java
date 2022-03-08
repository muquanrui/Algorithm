package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 08/03/2022 21:36
 */
public class LeetCode0055 {
    public boolean canJump(int[] nums) {
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (far < i) {
                break;
            }
            far = Math.max(far, i + nums[i]);
            if (far >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
