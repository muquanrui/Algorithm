package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 14:04
 */
public class LeetCode0376 {
    public int wiggleMaxLength(int[] nums) {
        int preDiff = 0;
        int curDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
