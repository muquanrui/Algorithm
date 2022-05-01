package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 14:44
 */
public class LeetCode0977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = res.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int lPow = nums[left] * nums[left];
            int rPow = nums[right] * nums[right];
            if (lPow > rPow) {
                res[i--] = lPow;
                left++;
            } else {
                res[i--] = rPow;
                right--;
            }
        }
        return res;
    }
}
