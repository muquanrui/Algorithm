package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 30/10/2021 21:07
 */

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        // System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = String.valueOf(max).length();

        int bucket[][] = new int[10][arr.length];
        int bucketElementCount[] = new int[10];
        int remainder = 0;
        int temp = 0;

        for (int iterTime = 0; iterTime < maxLength; iterTime++) {
            for (int i = 0; i < arr.length; i++) {
                remainder = arr[i] / (int)Math.pow(10, iterTime) % 10;
                bucket[remainder][bucketElementCount[remainder]] = arr[i];
                bucketElementCount[remainder]++;
            }

            temp = 0;

            for (int i = 0; i < bucketElementCount.length; i++) {
                if (bucketElementCount[i] > 0) {
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        arr[temp] = bucket[i][j];
                        temp++;
                    }
                    bucketElementCount[i] = 0;
                }
            }
        }
    }
}

