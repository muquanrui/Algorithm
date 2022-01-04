package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 04/01/2022 07:38
 */
public class LeetCode0300 {
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int res = 0;
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < list.get(0)) {
                list.set(0, nums[i]);
            } else if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[i] <= list.get(mid)) {
                        right = mid;
                    } else if (nums[i] > list.get(mid + 1)) {
                        left = mid + 1;
                    } else {
                        list.set(mid + 1, nums[i]);
                        break;
                    }
                }
            }
        }
        return list.size();
    }
}
