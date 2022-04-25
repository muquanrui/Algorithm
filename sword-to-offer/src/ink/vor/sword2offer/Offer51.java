package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/25 16:06
 */
public class Offer51 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(array, left, mid);
        count += mergeSort(array, mid + 1, right);
        count += merge(array, left, mid, right);
        return count;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        int count = 0;
        while (l <= mid && r <= right) {
            if (array[l] > array[r]) {
                count += mid - l + 1;
                temp[i++] = array[r++];
            } else {
                temp[i++] = array[l++];
            }
        }
        while (l <= mid) {
            temp[i++] = array[l++];
        }
        while (r <= right) {
            temp[i++] = array[r++];
        }
        i = 0;
        while (i < temp.length) {
            array[left++] = temp[i++];
        }
        return count;
    }
}
