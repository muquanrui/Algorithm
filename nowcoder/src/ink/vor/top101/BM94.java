package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:46
 */
public class BM94 {
    public long maxWater (int[] arr) {
        return trap(arr);
    }

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int[] bounds = new int[2];
        bounds[0] = Math.min(height[left], height[right]);
        bounds[1] = Math.max(height[left], height[right]);
        int volumn = 0;
        while (left < right - 1) {
            int cur;
            if (height[left] <= height[right]) {
                cur = height[++left];
            } else {
                cur = height[--right];
            }

            if (cur <= bounds[0]) {
                volumn += bounds[0] - cur;
            } else if (cur <= bounds[1]) {
                bounds[0] = cur;
            } else {
                bounds[0] = bounds[1];
                bounds[1] = cur;
            }
        }
        return volumn;
    }
}
