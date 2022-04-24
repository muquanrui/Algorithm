package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/24 15:04
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
