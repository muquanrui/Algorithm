package ink.vor.monotonicstack;

/**
 * @author muquanrui
 * @date 2022/5/15 17:09
 */
public class LeetCode0042 {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = max;
            max = Math.max(max, height[j]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (tmp > 0) {
                res += tmp;
            }
        }
        return res;
    }
}
