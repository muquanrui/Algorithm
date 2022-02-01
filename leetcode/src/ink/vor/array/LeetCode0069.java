package ink.vor.array;

/**
 * @author muquanrui
 * @date 01/02/2022 16:03
 */
public class LeetCode0069 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
