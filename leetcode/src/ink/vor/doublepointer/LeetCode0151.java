package ink.vor.doublepointer;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 14/02/2022 21:13
 */
public class LeetCode0151 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(0, arr.length - 1, arr);

        int start = 0;
        int end = start;
        int temp = start;

        while (end < arr.length) {
            while (end < arr.length && arr[end] == ' ') {
                end++;
            }
            while (end < arr.length && arr[end] != ' ') {
                arr[temp] = arr[end];
                temp++;
                end++;
            }
            if (temp <= arr.length && temp > start) {
                reverse(start, temp - 1, arr);
                if (temp != arr.length) {
                    arr[temp] = ' ';
                }
                temp++;
                start = temp;
            }
        }
        return new String(Arrays.copyOf(arr, start - 1));
    }

    public void reverse(int start, int end, char[] arr) {
        int left = start;
        int right = end;
        while (left < right) {
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left] ^= arr[right];
            left++;
            right--;
        }
    }
}
