package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 16:03
 */
public class LeetCode0045 {
    public int jump(int[] nums) {
        int steps = 0;
        int cover = 0;
        int curCover = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (i == curCover) {
                steps++;
                curCover = cover;
            }
            if (curCover >= nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }
}
