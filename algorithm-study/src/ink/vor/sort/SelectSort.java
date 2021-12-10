package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 24/10/2021 09:45
 */
//选择排序
public class SelectSort {

    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
       for (int i = 0; i < arr.length - 1; i++) {
           int minIndex = i;
           int minValue = arr[i];
           for (int j = i + 1; j < arr.length; j++) {
               if (arr[j] < minValue) {
                   minIndex = j;
                   minValue = arr[j];
               }
           }
           if (minIndex != i) {
               arr[minIndex] = arr[i];
               arr[i] = minValue;
           }
           System.out.println("第"+(i+1)+"轮后~~");
           System.out.println(Arrays.toString(arr));
       }
    }
}
