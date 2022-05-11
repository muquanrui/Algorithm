package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/11 18:19
 */
public class LeetCode0738 {
    public int monotoneIncreasingDigits(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
            i++;
        }
        if (i == sb.length() - 1) {
            return n;
        }
        for (int j = i + 1; j < sb.length(); j++) {
            sb.setCharAt(j, '9');
        }
        sb.setCharAt(i, (char)(sb.charAt(i) - 1));
        for (int k = i - 1; k >= 0 && sb.charAt(k) > sb.charAt(k + 1); k--) {
            sb.setCharAt(k + 1, '9');
            sb.setCharAt(k, (char)(sb.charAt(k) - 1));
        }
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return Integer.valueOf(sb.toString());
    }
}
