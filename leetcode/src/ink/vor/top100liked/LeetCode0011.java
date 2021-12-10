package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 29/11/2021 14:20
 */
public class LeetCode0011 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxContainer = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxContainer = Math.max(maxContainer, Math.min(height[l], height[r]) * (r -  l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxContainer;
    }
}
