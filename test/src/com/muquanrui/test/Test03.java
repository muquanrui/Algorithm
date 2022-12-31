package com.muquanrui.test;

import java.lang.*;
import java.io.*;

/**
 * @author muquanrui
 * @date 2022/9/15 18:26
 */

public class Test03 {
    public static void main(String[] args) {
       try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
           int length = Integer.parseInt(br.readLine());
           String[] strs = new String[length];
           for (int i = 0; i < length; i++) {
               strs[i] = br.readLine();
           }
           System.out.println(getBiggestScore(strs));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static int getBiggestScore(String[] strs) {
        int[] scores = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            scores[i] = getScore(strs[i]);
        }
        int max = 0;
        for (int score : scores) {
            max = Math.max(max, score);
        }
        return max;
    }

    private static int getScore(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : count) {
            if (i == 0) {
                continue;
            }
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}
