package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 08/12/2021 13:29
 */
public class LeetCode0056 {
    public static void main(String[] args) {
        int[][] nums = {{2,3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] res = merge(nums);
        for (int[] arr: res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> resList = new ArrayList<>();
        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];

        for (int i  = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= upperBound) {
                upperBound = Math.max(upperBound, intervals[i][1]);
            } else {
                resList.add(new int[]{lowerBound, upperBound});
                lowerBound = intervals[i][0];
                upperBound = intervals[i][1];
            }
        }
        resList.add(new int[]{lowerBound, upperBound});

        int[][] res = new int[resList.size()][2];
        int i = 0;
        for (int[] arr: res) {
            arr[0] = resList.get(i)[0];
            arr[1] = resList.get(i)[1];
            i++;
        }

        return res;
    }
}
