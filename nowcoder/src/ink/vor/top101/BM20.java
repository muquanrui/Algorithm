package ink.vor.top101;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 03/04/2022 03:34
 */
public class BM20 {
    public int InversePairs(int [] array) {
        if (array.length == 0 || array.length == 1) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1) % 1000000007;
    }

    private int mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSort(array, left, mid);
        count += mergeSort(array, mid + 1, right);
        count += merge(array, left, mid, right);
        return count;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        int count = 0;
        while (l <= mid && r <= right) {
            if (array[l] > array[r]) {
                count += mid - l + 1;
                count %= 1000000007;
                tempArr[i++] = array[r++];
            } else {
                tempArr[i++] = array[l++];
            }
        }
        while (l <= mid) {
            tempArr[i++] = array[l++];
        }
        while (r <= right) {
            tempArr[i++] = array[r++];
        }
        i = 0;
        while (i < tempArr.length) {
            array[left++] = tempArr[i++];
        }
        return count;
    }
}