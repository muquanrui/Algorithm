package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 08/01/2022 13:06
 */
public class LeetCode0494 {
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        recursiveSum(nums, 0, 0, target);
        return res;
    }

    public int res;
    public void recursiveSum(int[] nums, int start, int sum, int target) {
        int sumPlus = sum + nums[start];
        int sumMinus = sum - nums[start];
        if (start == nums.length - 1) {
            if (sumPlus == target) {
                res++;
            }
            if (sumMinus == target) {
                res++;
            }
            return;
        }
        recursiveSum(nums, start + 1, sumPlus, target);
        recursiveSum(nums, start + 1, sumMinus, target);
    }
}
