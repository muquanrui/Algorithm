package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/11/24 12:13
 */

// https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
public class LeetCode0795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        for (int i = 0, j = -1, k = -1; i < nums.length; i++) {
            if (nums[i] > right) {
                k = i;
            } else if (nums[i] < left) {
                if (j > k) {
                    res += j - k;
                }
            } else {
                res += i - k;
                j = i;
            }
        }
        return res;
    }
}
