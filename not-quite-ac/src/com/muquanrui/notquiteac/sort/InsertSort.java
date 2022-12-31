package com.muquanrui.notquiteac.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/12 16:23
 */

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 3, -1, 20, 10};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int inserValue = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > inserValue) {
                arr[insertIndex + 1] = arr[insertIndex--];
            }
            arr[insertIndex + 1] = inserValue;
        }
    }
}
