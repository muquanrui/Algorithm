package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/17 11:11
 */

public class Test09 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int x = Integer.parseInt(inputs[1]);
            int y = Integer.parseInt(inputs[2]);
            String[] bucket1 = br.readLine().split(" ");
            String[] bucket2 = br.readLine().split(" ");
            Deque<Integer> stack1 = new LinkedList<>();
            Set<Integer> set1 = new HashSet<>();
            for (String s : bucket1) {
                stack1.push(Integer.parseInt(s));
                set1.add(Integer.parseInt(s));
            }
            Deque<Integer> stack2 = new LinkedList<>();
            Set<Integer> set2 = new HashSet<>();
            for (String s : bucket2) {
                stack2.push(Integer.parseInt(s));
                set2.add(Integer.parseInt(s));
            }
            System.out.println(solve(n, stack1, stack2, set1, set2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solve(int n, Deque<Integer> stack1, Deque<Integer> stack2, Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set1.contains(i)) {
                while (stack1.peek() != i) {
                    int cur = stack1.pop();
                    set1.remove(cur);
                    stack2.push(cur);
                    set2.add(cur);
                    count++;
                }
                int cur = stack1.pop();
                set1.remove(cur);
                count++;
            } else {
                while (stack2.peek() != i) {
                    int cur = stack2.pop();
                    set2.remove(cur);
                    stack1.push(cur);
                    set1.add(cur);
                    count++;
                }
                int cur = stack2.pop();
                set2.remove(cur);
                count++;
            }
        }
        return count;
    }
}
