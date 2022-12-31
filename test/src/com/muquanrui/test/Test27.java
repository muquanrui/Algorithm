package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author muquanrui
 * @date 2022/10/13 13:12
 */

public class Test27 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            System.out.println(solve(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }
}
