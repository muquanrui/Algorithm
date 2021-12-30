package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 30/12/2021 12:16
 */
public class LeetCode0238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 1; i < res.length; i++) {
            product *= nums[i - 1];
            res[i] = product;
        }
        product = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        res[0] = product;
        return res;
    }
}
