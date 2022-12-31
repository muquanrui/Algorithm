package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/24 20:02
 */

public class Test13 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                String[] inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                map = new HashMap<>();
                System.out.println(solve(x, y) ? "kou" : "yukari");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<Integer, Boolean> map;
    private static boolean solve(int x, int y) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        if (x * 2 >= y || x + 1 >= y) {
            map.put(x, true);
            return true;
        }
        boolean res = !solve(x * 2, y) || !solve(x + 1, y);
        map.put(x, res);
        return res;
    }
}
