package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 14:04
 */
public class LeetCode0069 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt < mid) {
                right = mid - 1;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else {
                return sqrt;
            }
        }
        return right;
    }
}
