package com.muquanrui.notquiteac.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/12 18:25
 */

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 3, -1, 20, 10};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        int l = left;
        int r = mid + 1;
        int[] tmp = new int[right - left + 1];
        int i = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tmp[i++] = arr[l++];
            } else {
                tmp[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            tmp[i++] = arr[l++];
        }
        while (r <= right) {
            tmp[i++] = arr[r++];
        }
        i = 0;
        for (int j = left; j <= right; j++) {
            arr[j] = tmp[i++];
        }
    }
}
