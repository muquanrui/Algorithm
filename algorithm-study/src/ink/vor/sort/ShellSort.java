package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 26/10/2021 09:01
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        System.out.println("排序前");
        System.out.println(Arrays   .toString(arr));
        shellSort2(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex > -1 && arr[insertIndex] > insertValue) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertValue;
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

}

