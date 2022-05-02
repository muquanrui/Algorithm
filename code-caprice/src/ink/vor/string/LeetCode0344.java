package ink.vor.string;

/**
 * @author muquanrui
 * @date 2022/5/2 15:42
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
