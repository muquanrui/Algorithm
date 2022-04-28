package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/28 18:05
 */
public class Offer67 {
    public int strToInt(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        boolean isNegative = false;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            isNegative = str.charAt(i) == '-';
            i++;
        }
        if (i == str.length() || str.charAt(i) > '9' || str.charAt(i) < '0') {
            return 0;
        }
        int res = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res *= 10;
            res += str.charAt(i) - '0';
            i++;
        }
        return isNegative ? -res : res;
    }
}
