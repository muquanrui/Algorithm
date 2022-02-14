package ink.vor.doublepointer;

/**
 * @author muquanrui
 * @date 14/02/2022 21:09
 */
public class LeetCode0344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
