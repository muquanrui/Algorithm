package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/9/27 16:30
 */

public class Test14 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            solve(num);
            if (flag) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i : res) {
                    sb.append(i + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void solve(int num) {
        res = new ArrayList<>();
        flag = false;
        isUsed = new boolean[num];
        backtracking(num);
    }
    static List<Integer> res;
    static boolean flag;
    static boolean[] isUsed;
    private static void backtracking(int num) {
        if (res.size() == num) {
            flag = true;
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (isUsed[i - 1] || isPrime(res.size() + i + 1)) {
                continue;
            }
            isUsed[i - 1] = true;
            res.add(i);
            backtracking(num);
            if (flag) {
                return;
            }
            res.remove(res.size() - 1);
            isUsed[i - 1] = false;
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1 || (n != 2 && n % 2 == 0)) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
