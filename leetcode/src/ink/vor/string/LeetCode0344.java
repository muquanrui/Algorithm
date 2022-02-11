package ink.vor.string;

/**
 * @author muquanrui
 * @date 11/02/2022 22:21
 */
public class LeetCode0344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
//            char temp = s[left];
//            s[left] = s[right];
//            s[right] = temp;
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
