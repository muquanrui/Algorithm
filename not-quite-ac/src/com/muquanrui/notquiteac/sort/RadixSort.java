package com.muquanrui.notquiteac.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/14 11:20
 */

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        // System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int op = 1;
        for (; ; ) {
            for (int i = 0; i < arr.length; i++) {
                int remainder = arr[i] / op % 10;
                bucket[remainder][bucketCount[remainder]++] = arr[i];
            }
            int index = 0;
            for (int i = 0; i < bucketCount.length; i++) {
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            if (bucketCount[0] == arr.length) {
                return;
            }
            op *= 10;
            bucketCount = new int[10];
        }
    }
}
