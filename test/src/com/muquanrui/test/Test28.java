package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author muquanrui
 * @date 2022/10/13 13:14
 */

public class Test28 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            String[] ns = br.readLine().split(" ");
            int[] arr = new int[length + 1];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(ns[i]);
            }
            int insert = Integer.parseInt(br.readLine());
            arr[length] = insert;
            solve(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[] arr) {
        int insertValue = arr[arr.length - 1];
        int insertIndex = arr.length - 2;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex--];
        }
        arr[insertIndex + 1] = insertValue;
    }
}
