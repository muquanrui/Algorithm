package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 13/03/2022 15:06
 */
public class LeetCode0738 {
    public int monotoneIncreasingDigits(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int i = 1;
        for (; i < num.length; i++) {
            if (num[i] < num[i - 1]) {
                break;
            }
        }
        if (i == num.length) {
            return n;
        }
        for (int j = i; j < num.length; j++) {
            num[j] = '9';
        }
        i--;
        while (i - 1 >= 0 && num[i] == num[i - 1]) {
            num[i] = '9';
            i--;
        }
        num[i] = (char)(num[i] - '1' + 48);
        String str = new String(num);
        str = str.startsWith("0") ? str.substring(1) : str;
        return Integer.parseInt(str);
    }
}
