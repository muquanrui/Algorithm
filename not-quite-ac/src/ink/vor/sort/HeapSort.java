package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/14 11:34
 */

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {72, 87, 61, 23, 94, 16, 5, 58};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        // System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int start, int end) {
        int tmp = arr[start];
        for (int i = 2 * start + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end && arr[i + 1] > arr[i]) {
                i++;
            }
            if (tmp > arr[i]) {
                break;
            }
            arr[start] = arr[i];
            start = i;
        }
        arr[start] = tmp;
    }
}
