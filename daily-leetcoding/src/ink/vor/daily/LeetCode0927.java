package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/10/6 19:36
 */

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/three-equal-parts/
 */
public class LeetCode0927 {
    public int[] threeEqualParts(int[] arr) {
        int count1 = Arrays.stream(arr).sum();
        if (count1 == 0) {
            return new int[]{0, 2};
        }
        if (count1 % 3 != 0) {
            return new int[]{-1, -1};
        }
        int length = count1 / 3, first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == length) {
                    second = i;
                } else if (cur == 2 * length) {
                    third = i;
                }
                cur++;
            }
        }
        int offset = arr.length - third;
        if (first + offset <= second && second + offset <= third) {
            for (int i = 0; i < offset; i++) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
            }
            return new int[]{first + offset - 1, second + offset};
        }
        return new int[]{-1, -1};
    }
}
