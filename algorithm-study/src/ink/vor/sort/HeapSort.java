package ink.vor.sort;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 04/11/2021 20:35
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

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("堆排序!!");

        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    //将一个数组(二叉树), 调整成一个大顶堆
    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public  static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1){
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            }
            else {
                break;
            }
        }
        arr[i] = temp;
    }
}