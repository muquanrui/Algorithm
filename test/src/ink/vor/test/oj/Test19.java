package ink.vor.test.oj;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/9/29 20:06
 */

public class Test19 {
    public int histogram_max_area (int[] histogram) {
        // write code here
        int[] leftBound = new int[histogram.length];
        Arrays.fill(leftBound, -1);
        Deque<Integer> stack = new LinkedList();
        for (int i = histogram.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && histogram[i] < histogram[stack.peek()]) {
                leftBound[stack.pop()] = i;
            }
            stack.push(i);
        }
        int[] rightBound = new int[histogram.length];
        Arrays.fill(rightBound, histogram.length);
        stack = new LinkedList();
        for (int i = 0; i <= histogram.length - 1; i++) {
            while (!stack.isEmpty() && histogram[i] < histogram[stack.peek()]) {
                rightBound[stack.pop()] = i;
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < histogram.length; i++) {
            res = Math.max(res, (rightBound[i] - leftBound[i] - 1) * histogram[i]);
        }
        return res;
    }
}
