package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 14:09
 */
public class LeetCode0367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double sqrt = num * 1.0 / mid;
            if (sqrt < mid) {
                right = mid - 1;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
