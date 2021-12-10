package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 06/12/2021 10:48
 */
public class LeetCode0045 {
    public static void main(String[] args) {
        int[] nums = {2,1,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int step = 0;
        int lastIndex = nums.length - 1;
        int i = 0;
        while (i < lastIndex) {
            if (nums[i] >= lastIndex - i) {
                lastIndex = i;
                i = 0;
                step++;
            } else {
                i++;
            }
        }
        return step;
    }

}
