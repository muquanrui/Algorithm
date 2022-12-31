package com.muquanrui.newcoder.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/8/20 13:29
 */
public class Test04 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // int count = Integer.parseInt(br.readLine());
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(" ");
                int i1 = Integer.parseInt(strs[0]);
                int i2 = Integer.parseInt(strs[1]);
                System.out.println(i1 + i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
