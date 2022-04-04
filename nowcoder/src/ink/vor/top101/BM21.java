package ink.vor.top101;

/**
 * @author muquanrui
 * @date 04/04/2022 14:29
 */
public class BM21 {
    public int minNumberInRotateArray(int [] array) {
        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
