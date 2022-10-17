package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/12 16:18
 */

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 3, -1, 20, 10};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
            }
        }
    }
}
