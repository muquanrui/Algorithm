package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/9/24 19:34
 */

public class Test12 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int length = Integer.parseInt(inputs[0]);
            int seqnum = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split(" ");
            int[] nums = new int[length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println(solve(nums, seqnum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[] nums, int seqnum) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        int count = 0;
        while (count < seqnum && length > seqnum - count) {
            res += nums[right--] - nums[left++];
            count++;
            length -= 2;
        }
        return res;
    }
}
