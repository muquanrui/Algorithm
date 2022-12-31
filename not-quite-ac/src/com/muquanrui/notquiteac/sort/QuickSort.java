package com.muquanrui.notquiteac.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/12 17:35
 */

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 3, -1, 20, 10};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (r > l && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
}
