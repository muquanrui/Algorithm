package ink.vor.onceagain;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/29 16:08
 */

/**
 * https://leetcode.cn/problems/next-greater-element-i/
 * 单调递增栈
 */
public class LeetCode0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return res;
    }
}
