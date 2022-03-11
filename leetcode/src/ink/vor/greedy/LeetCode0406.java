package ink.vor.greedy;

import java.util.*;

/**
 * @author muquanrui
 * @date 11/03/2022 21:35
 */
public class LeetCode0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        }));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        return list.toArray(new int[people.length][]);
    }
}
