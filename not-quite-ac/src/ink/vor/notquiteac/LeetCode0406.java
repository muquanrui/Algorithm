package ink.vor.notquiteac;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/28 20:03
 */
public class LeetCode0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return Integer.compare(arr1[1], arr2[1]);
            }
            return Integer.compare(arr2[0], arr1[0]);
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.removeFirst();
        }
        return people;
    }
}
