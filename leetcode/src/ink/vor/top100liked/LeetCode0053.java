package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 06/12/2021 18:38
 */
public class LeetCode0053 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int tempSum = nums[0];
        int maxSum = tempSum;
        for (int i = 1; i < nums.length; i++) {
            if (tempSum < 0) {
                tempSum = Math.max(tempSum, nums[i]);
            } else {
                tempSum += nums[i];
            }
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }
}
