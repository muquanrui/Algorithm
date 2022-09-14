package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/27 16:18
 */

/**
 * https://leetcode.cn/problems/valid-perfect-square/
 * 二分查找
 */
public class LeetCode0367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double cur = num * 1.0 / mid;
            if (cur < mid) {
                right = mid - 1;
            } else if (cur > mid) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
