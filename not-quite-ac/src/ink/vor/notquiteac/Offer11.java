package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/11 18:44
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[right];
    }
}
