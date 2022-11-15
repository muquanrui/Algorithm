package ink.vor.daily;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/11/15 19:31
 */

// https://leetcode.cn/problems/maximum-units-on-a-truck/
public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (arr1, arr2) -> arr2[1] - arr1[1]);
        int sum = 0;
        int size = truckSize;
        for (int i = 0; i < boxTypes.length; i++) {
            if (size >= boxTypes[i][0]) {
                size -= boxTypes[i][0];
                sum += boxTypes[i][0] * boxTypes[i][1];
            } else {
                sum += size * boxTypes[i][1];
                break;
            }
        }
        return sum;
    }
}
