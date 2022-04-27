package ink.vor.sword2offer;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/27 15:08
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        int countJoker = 0;
        Arrays.sort(nums);
        int i = 0;
        while (nums[i] == 0) {
            countJoker++;
            i++;
        }
        i++;
        while (i < 5) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            countJoker -= nums[i] - nums[i - 1] - 1;
            i++;
        }
        return countJoker >= 0;
    }
}
