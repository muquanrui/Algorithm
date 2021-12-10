package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 24/10/2021 09:16
 */

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
        //测试冒泡排序
        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    // 将前面额冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
            else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
