package ink.vor.greedy;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/5/11 14:28
 */
public class LeetCode0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] arr1, int[] arr2) -> {
            if (arr1[0] == arr2[0]) {
                return Integer.compare(arr1[1], arr2[1]);
            }
            return Integer.compare(arr2[0], arr1[0]);
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[0][]);
    }
}
