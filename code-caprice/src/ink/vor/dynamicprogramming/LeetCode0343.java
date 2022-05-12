package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 09:01
 */
public class LeetCode0343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int)Math.pow(3, res);
        }
        if (remainder == 1) {
            return (int)Math.pow(3, res - 1) * 4;
        }
        return (int)Math.pow(3, res) * 2;
    }
}
