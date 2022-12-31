package com.muquanrui.newcoder.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/8/12 13:20
 */

/*
一排学生共  个人在一起听课，分别坐在位置 ，每个人都有一个听课认真度 a_i，这时来了一个调皮的插班生，他会影响别人听课。具体来说，距离他  的学生（距离即两个人位置之差的绝对值），听课认真度将减少 ，注意，一位学生的听课认真度不会因为插班生的到来而被降低到负数（即最少被降低到 0）。总共有  个座位供插班生选择，被占领座位的学生将被踢出班级，其他人的座位不变，但听课认真度会减少。现在想知道，如果插班生坐在了位置 ，所有学生的听课认真度之和分别是多少。（插班生没有听课认真度）

输入描述:
第一行输入一个正整数 ， 表示学生的个数。

接下来一行输入  个正整数 ，表示每个学生的听课认真度。


输出描述:
输出  个正整数，其中第  个正整数表示当插班生坐在位置  时，所有学生的听课认真度之和。

输入例子1:
5
10 1 10 10 10

输出例子1:
24 27 20 20 22
*/
public class Test03 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                int n = Integer.parseInt(line);
                String[] str = br.readLine().split(" ");
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(str[i]);
                }
                System.out.println(Arrays.toString(calculate(arr)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] calculate(int[] arr) {
        int[] res = new int[arr.length];
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        for (int pos = 0; pos < res.length; pos++) {
            int curSum = sum;
            curSum -= arr[pos];
            for (int i = 0; i < arr.length; i++) {
                if (i == pos) {
                    continue;
                }
                int diff = arr.length - Math.abs(pos - i);
                if (diff > arr[i]) {
                    diff = arr[i];
                }
                curSum -= diff;
            }
            res[pos] = curSum;
        }
        return res;
    }
}
