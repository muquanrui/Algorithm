package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 09/03/2022 21:05
 */
public class LeetCode0045 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int far = 0;
        int nextFar = far;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return step + 1;
            }
            nextFar = Math.max(nextFar, i + nums[i]);
            if (i == far) {
                far = nextFar;
                step++;
            }
        }
        return step;
    }
}
