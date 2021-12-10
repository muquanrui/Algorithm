package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 07/12/2021 10:47
 */
public class LeetCode0055 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        int[] nums1 = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int far = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (far < i) {
                break;
            }
            far = Math.max(far, i + nums[i]);
        }
        return far >= nums.length - 1;
    }
}
