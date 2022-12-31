package com.muquanrui.test;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2022/10/18 15:56
 */

public class Test31 {
    public static int reductionCost(List<Integer> num) {
        // Write your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer i : num) {
            priorityQueue.add(i);
        }
        int cost = 0;
        while (priorityQueue.size() > 1) {
            int remove1 = priorityQueue.poll();
            int remove2 = priorityQueue.poll();
            int add = remove1 + remove2;
            cost += add;
            priorityQueue.offer(add);
        }
        return cost;
    }
}
