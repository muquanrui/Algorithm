package com.muquanrui.dailyleetcoding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * @author muquanrui
 * @date 2023/2/19 14:00
 */

public class LeetCode1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2)
                -> Double.compare((o2[0] + 1) * 1.0 / (o2[1] + 1) - o2[0] * 1.0 / o2[1], (o1[0] + 1) * 1.0 / (o1[1] + 1) - o1[0] * 1.0 / o1[1]));
        for (int[] c : classes) {
            priorityQueue.add(c);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = priorityQueue.poll();
            poll[0]++;
            poll[1]++;
            priorityQueue.add(poll);
        }
        return priorityQueue.stream().mapToDouble(value -> value[0] * 1.0 / value[1]).sum() / classes.length;
    }
}
