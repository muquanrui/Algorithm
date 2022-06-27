package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/27 16:18
 */
public class LeetCode0367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num / (mid * 1.0) > mid) {
                left = mid + 1;
            } else if (num / (mid * 1.0) < mid) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
