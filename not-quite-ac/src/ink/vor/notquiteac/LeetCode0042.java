package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/1 16:35
 */

// https://leetcode.cn/problems/trapping-rain-water/
public class LeetCode0042 {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int[] maxLeft = new int[height.length - 2];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length - 2; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        int res = 0;
        int maxRight = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            if (height[i] < maxLeft[i - 1] && height[i] < maxRight) {
                res += Math.min(maxLeft[i - 1], maxRight) - height[i];
            }
            maxRight = Math.max(maxRight, height[i]);
        }
        return res;
    }
}
