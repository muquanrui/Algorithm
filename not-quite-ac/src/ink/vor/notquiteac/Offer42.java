package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/18 11:50
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
