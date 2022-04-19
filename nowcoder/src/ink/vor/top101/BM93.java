package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:46
 */
public class BM93 {
    public int maxArea (int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                res = Math.max(res, height[l] * (r - l));
                l++;
            } else {
                res = Math.max(res, height[r] * (r - l));
                r--;
            }
        }
        return res;
    }
}
