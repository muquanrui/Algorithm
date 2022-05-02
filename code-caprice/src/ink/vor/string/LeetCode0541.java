package ink.vor.string;

/**
 * @author muquanrui
 * @date 2022/5/2 15:47
 */
public class LeetCode0541 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            int left = i;
            int right = i + k - 1 >= str.length ? str.length - 1 : i + k - 1;
            while (left < right) {
                str[left] ^= str[right];
                str[right] ^= str[left];
                str[left] ^= str[right];
                left++;
                right--;
            }
        }
        return new String(str);
    }
}
