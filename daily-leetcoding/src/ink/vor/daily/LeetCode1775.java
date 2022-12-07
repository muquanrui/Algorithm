package ink.vor.daily;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/12/7 20:10
 */

public class LeetCode1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) {
            return 0;
        }
        int[] smaller = nums1;
        int[] bigger = nums2;
        if (sum1 > sum2) {
            smaller = nums2;
            bigger = nums1;
        }
        int diff = Math.abs(sum1 - sum2);
        int[] diffMap = new int[6];
        for (int i : smaller) {
            diffMap[6 - i]++;
        }
        for (int i : bigger) {
            diffMap[i - 1]++;
        }
        int count = 0;
        for (int i = diffMap.length - 1; i >= 0; i--) {
            while (diffMap[i] > 0) {
                count++;
                if (diff <= i) {
                    return count;
                }
                diff -= i;
                diffMap[i]--;
            }
        }
        return -1;
    }
}
