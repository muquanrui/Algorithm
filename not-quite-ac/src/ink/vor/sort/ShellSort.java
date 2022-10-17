package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/12 17:20
 */

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, 3, -1, 20, 10};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= i - gap && arr[insertIndex] > insertValue) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertValue;
            }
        }
    }
}
