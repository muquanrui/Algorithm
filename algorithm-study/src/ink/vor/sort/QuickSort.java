package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 27/10/2021 11:17
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
//        int[] arr = {1, 5, 1, 4};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[left];
        int temp = 0;

        while (l < r ) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l == r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        l++;
        r--;

        if (l < right) {
            quickSort(arr, l, right);
        }
        if (r > left) {
            quickSort(arr, left, r);
        }
    }
}
