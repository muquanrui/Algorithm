package ink.vor.string;

/**
 * @author muquanrui
 * @date 11/02/2022 23:06
 */
public class LeetCode0541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int index = 0;
        while (index < arr.length) {
            int left = index;
            int right = index + k  - 1 < arr.length ? index + k - 1 : arr.length - 1;
            while (left < right) {
                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
                left++;
                right--;
            }
            index += 2 * k;
        }
        return new String(arr);
    }
}
