package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/22 21:27
 */

public class LeetCode1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2];
        for (int i = 1; i < jobs.length; i++) {
            int left = 0;
            int right = i - 1;
            int target = jobs[i][0];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (jobs[mid][1] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int last = right;
            dp[i] = last >= 0 ? Math.max(dp[i - 1], dp[last] + jobs[i][2]) : Math.max(dp[i - 1], jobs[i][2]);
        }
        return dp[jobs.length - 1];
    }
}
