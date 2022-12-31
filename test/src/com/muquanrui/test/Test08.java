package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/9/17 10:35
 */

public class Test08 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int length = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            int[] nums = new int[length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(convert(nums));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int convert(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int res = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.abs(i + j - nums[j]);
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}

