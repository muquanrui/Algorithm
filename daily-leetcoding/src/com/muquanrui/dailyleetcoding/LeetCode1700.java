package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/10/19 13:17
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 */
public class LeetCode1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i : students) {
            deque.offer(i);
        }
        int sandwichI = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int count = 0;
            while (deque.peek() != sandwiches[sandwichI]) {
                deque.offer(deque.poll());
                count++;
                if (count == size) {
                    return deque.size();
                }
            }
            deque.poll();
            sandwichI++;
        }
        return 0;
    }
}
