package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 07/03/2022 21:27
 */
public class LeetCode0376 {
    public int wiggleMaxLength(int[] nums) {
        int[] rise = new int[nums.length];
        int[] fall = new int[nums.length];
        rise[0] = 1;
        fall[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                rise[i] = Math.max(rise[i - 1], fall[i - 1] + 1);
                fall[i] = fall[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                rise[i] = rise[i - 1];
                fall[i] = Math.max(fall[i - 1], rise[i - 1] + 1);
            } else {
                rise[i] = rise[i - 1];
                fall[i] = fall[i - 1];
            }
        }
        return Math.max(rise[nums.length - 1], fall[nums.length - 1]);
    }
}
