package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 24/10/2021 10:59
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertIndex = 0;
        int insertValue = 0;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertValue = arr[i];
            while (insertIndex > -1 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));
        }
    }
}

