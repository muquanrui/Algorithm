package ink.vor.array;

/**
 * @author muquanrui
 * @date 01/02/2022 16:28
 */
public class LeetCode0367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num / mid < mid) {
                right = mid - 1;
            } else if (num / mid > mid) {
                left = mid + 1;
            } else {
                if (num % mid == 0) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
