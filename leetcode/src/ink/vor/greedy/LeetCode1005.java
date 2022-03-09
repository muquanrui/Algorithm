package ink.vor.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author muquanrui
 * @date 09/03/2022 21:30
 */
public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (cur < nums.length - 1 && nums[cur] < 0) {
                nums[cur] = -nums[cur];
                if (Math.abs(nums[cur]) >= Math.abs(nums[cur + 1])) {
                    cur++;
                }
            } else {
                nums[cur] = -nums[cur];
            }
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
