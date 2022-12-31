package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/10/9 16:23
 */

public class Test22 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] keys = new int[n];
            for (int i = 0; i < n; i++) {
                keys[i] = Integer.parseInt(inputs[i]);
            }
            doors = new boolean[n + 1];
            doors[0] = true;
            res = new int[n];
            solve(keys, n);
            StringBuilder sb = new StringBuilder();
            for (int i : res) {
                sb.append(i + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean[] doors;
    static int[] res;
    private static void solve(int[] keys, int n) {
        Set<Integer> keysInHand = new HashSet<>();
        int today = 1;
        for (int i = 0; i < keys.length; i++, today++) {
            int door = keys[i];
            keysInHand.add(door);
            while (keysInHand.contains(door) && doors[door - 1]) {
                doors[door] = true;
                keysInHand.remove(door);
                res[door - 1] = today;
                door = door + 1;
            }
        }
    }
}
