package ink.vor.top100liked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 16/12/2021 16:24
 */
public class LeetCode0136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
